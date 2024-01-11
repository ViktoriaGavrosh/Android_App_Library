package com.viktoriagavrosh.mylibrary.ui.utils

import com.viktoriagavrosh.mylibrary.model.Book
import com.viktoriagavrosh.mylibrary.ui.screens.LibraryUiState

sealed interface NavigationType {
    data object Loading : NavigationType
    data object Error : NavigationType
    data object Start : NavigationType
    data object Success : NavigationType
    data class Details(val book: Book) : NavigationType
}