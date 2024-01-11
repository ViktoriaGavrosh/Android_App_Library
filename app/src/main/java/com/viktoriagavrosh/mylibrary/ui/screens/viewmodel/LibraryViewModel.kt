package com.viktoriagavrosh.mylibrary.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.viktoriagavrosh.mylibrary.LibraryApplication
import com.viktoriagavrosh.mylibrary.data.BooksRepository
import com.viktoriagavrosh.mylibrary.model.Book
import com.viktoriagavrosh.mylibrary.ui.utils.NavigationType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class LibraryViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    private var _uiState = MutableStateFlow(LibraryUiState())
    val libraryUiState: StateFlow<LibraryUiState> = _uiState.asStateFlow()

    fun getBooksList() {
        var navigationType: NavigationType
        var bookList: List<Book> = emptyList()
        viewModelScope.launch {
            navigationType = try {
                bookList = booksRepository.getBooks(_uiState.value.textQuery)
                NavigationType.Success
            } catch (e: IOException) {
                NavigationType.Error
            } catch (e: HttpException) {
                NavigationType.Error
            }
            _uiState.update {
                it.copy(
                    navigationType = navigationType,
                    bookList = bookList
                )
            }
        }
    }

    fun goToHomeScreen() {
        _uiState.update {
            it.copy(
                navigationType = NavigationType.Loading
            )
        }
        getBooksList()
    }

    fun updateTextQuery(text: String) {
        _uiState.update {
            it.copy(
                textQuery = text
            )
        }
    }

    fun goToDetailScreen(book: Book) {
        val navigationType = NavigationType.Details(book)
        _uiState.update {
            it.copy(
                navigationType = navigationType
            )
        }
    }

    fun returnToHomeScreen() {
        val navigationType = NavigationType.Success
        _uiState.update {
            it.copy(
                navigationType = navigationType
            )
        }
    }

    fun returnToStartScreen() {
        _uiState.update {
            it.copy(
                textQuery = "",
                navigationType = NavigationType.Start
            )
        }
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