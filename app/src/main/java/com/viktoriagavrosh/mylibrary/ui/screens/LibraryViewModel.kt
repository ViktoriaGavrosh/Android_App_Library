package com.viktoriagavrosh.mylibrary.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.viktoriagavrosh.mylibrary.LibraryApplication
import com.viktoriagavrosh.mylibrary.data.BooksRepository
import com.viktoriagavrosh.mylibrary.model.Book
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface LibraryUiState {
    data object Loading : LibraryUiState
    data object Error : LibraryUiState
    data class Success(val booksList: List<Book>) : LibraryUiState
    data class Details(val book: Book) : LibraryUiState
}

class LibraryViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    var libraryUiState: LibraryUiState by mutableStateOf(LibraryUiState.Loading)
        private set

    init {
        getBooksList()
    }

    fun getBooksList() {
        viewModelScope.launch {
            libraryUiState = LibraryUiState.Loading
            libraryUiState = try {
                LibraryUiState.Success(booksRepository.getBooks())
            } catch (e: IOException) {
                LibraryUiState.Error
            } catch (e: HttpException) {
                LibraryUiState.Error
            }
        }
    }

    fun goToDetailScreen(book: Book) {
        libraryUiState = LibraryUiState.Details(book)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as LibraryApplication)
                val booksRepository = application.container.booksRepository
                LibraryViewModel(booksRepository = booksRepository)
            }
        }


    }
}