package com.viktoriagavrosh.mylibrary.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.viktoriagavrosh.mylibrary.model.Book
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface LibraryUiState {
    data object Loading : LibraryUiState
    data object Error : LibraryUiState
    data class Success(val booksList: List<Book>) : LibraryUiState
    data class Details(val book: Book) : LibraryUiState
}

class LibraryViewModel : ViewModel() {

    var libraryUiState: LibraryUiState by mutableStateOf(LibraryUiState.Loading)
        private set

    init {
        getBooksList()
    }

    fun getBooksList() {
        viewModelScope.launch {
            libraryUiState = LibraryUiState.Loading
            libraryUiState = try {
                // TODO LibraryUiState.Success(BooksRepository.getBooks())
                LibraryUiState.Success(listOf(Book("gg", "fff", listOf("ghh"), 234)))    // TODO delete
            } catch (e: IOException) {
                LibraryUiState.Error
            } catch (e: HttpException) {   // TODO change import!
                LibraryUiState.Error
            }
        }
    }

    fun goToDetailScreen(book: Book) {
        libraryUiState = LibraryUiState.Details(book)
    }
}