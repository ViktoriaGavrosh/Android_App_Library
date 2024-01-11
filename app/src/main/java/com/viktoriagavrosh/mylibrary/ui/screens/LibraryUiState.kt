package com.viktoriagavrosh.mylibrary.ui.screens

import com.viktoriagavrosh.mylibrary.model.Book
import com.viktoriagavrosh.mylibrary.ui.utils.NavigationType

data class LibraryUiState(
    val textQuery: String = "",
    val navigationType: NavigationType = NavigationType.Start,
    val bookList: List<Book> = emptyList()
)
