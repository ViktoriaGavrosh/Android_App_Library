package com.viktoriagavrosh.mylibrary.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.viktoriagavrosh.mylibrary.ui.screens.viewmodel.LibraryUiState
import com.viktoriagavrosh.mylibrary.ui.screens.viewmodel.LibraryViewModel
import com.viktoriagavrosh.mylibrary.ui.utils.NavigationType
import com.viktoriagavrosh.mylibrary.ui.utils.ScreenType

@Composable
fun LibraryHomeScreen(
    modifier: Modifier = Modifier,
    libraryUiState: LibraryUiState,
    libraryViewModel: LibraryViewModel,
    screenType: ScreenType
) {
    when (libraryUiState.navigationType) {
        is NavigationType.Start -> {
            StartScreen(
                libraryUiState = libraryUiState,
                onTextFieldChange = { libraryViewModel.updateTextQuery(it) },
                onButtonClick = { libraryViewModel.goToHomeScreen() },
                modifier = modifier
            )
        }

        is NavigationType.Details -> {
            DetailsScreen(
                book = libraryUiState.navigationType.book,
                screenType = screenType,
                onBackPressed = { libraryViewModel.returnToHomeScreen() },
                modifier = modifier
            )
        }

        is NavigationType.Success -> {
            LibraryGridScreen(
                listBook = libraryUiState.bookList,
                modifier = modifier,
                onBookClick = { libraryViewModel.goToDetailScreen(it) },
                onBackPressed = { libraryViewModel.returnToStartScreen() }
            )
        }

        is NavigationType.Loading -> {
            LoadingScreen(
                modifier = modifier
            )
        }

        is NavigationType.Error -> {
            ErrorScreen(
                modifier = modifier,
                onUpdateHomeScreen = { libraryViewModel.getBooksList() }
            )
        }
    }
}
