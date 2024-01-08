package com.viktoriagavrosh.mylibrary.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.viktoriagavrosh.mylibrary.R
import com.viktoriagavrosh.mylibrary.model.Book
import com.viktoriagavrosh.mylibrary.ui.screens.LibraryHomeScreen
import com.viktoriagavrosh.mylibrary.ui.screens.LibraryViewModel
import com.viktoriagavrosh.mylibrary.ui.theme.MyLibraryTheme

@Composable
fun LibraryApp(
    modifier: Modifier = Modifier
) {
    val libraryViewModel: LibraryViewModel = viewModel(factory = LibraryViewModel.Factory)

    Scaffold(
        topBar = { LibraryTopBar() }
    ) {
        Surface(
           modifier = modifier.padding(it)
        ) {
            LibraryHomeScreen(
                libraryUiState = libraryViewModel.libraryUiState,
                onUpdateHomeScreen = { libraryViewModel.getBooksList() },
                onBookClick = {
                    book: Book, booksList: List<Book> ->
                    libraryViewModel.goToDetailScreen(book, booksList)
                },
                onBackPressed = { bookList: List<Book> ->
                    libraryViewModel.returnToHomeScreen(bookList)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LibraryTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.library),
                style = MaterialTheme.typography.displaySmall
            )
        }
    )
}

@Preview
@Composable
fun LibraryTopBarPreview() {
    MyLibraryTheme {
        LibraryTopBar()
    }
}