package com.viktoriagavrosh.mylibrary.ui.screens

import com.viktoriagavrosh.mylibrary.model.Book
import com.viktoriagavrosh.mylibrary.ui.utils.NavigationType

data class LibraryUiState(
    val navigationType: NavigationType = NavigationType.Loading,
    val bookList: List<Book> = emptyList()
)
