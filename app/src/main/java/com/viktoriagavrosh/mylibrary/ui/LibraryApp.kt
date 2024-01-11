package com.viktoriagavrosh.mylibrary.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.viktoriagavrosh.mylibrary.R
import com.viktoriagavrosh.mylibrary.ui.screens.LibraryHomeScreen
import com.viktoriagavrosh.mylibrary.ui.screens.LibraryViewModel
import com.viktoriagavrosh.mylibrary.ui.theme.MyLibraryTheme
import com.viktoriagavrosh.mylibrary.ui.utils.ScreenType

@Composable
fun LibraryApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val libraryViewModel: LibraryViewModel = viewModel(factory = LibraryViewModel.Factory)
    val libraryUiState by libraryViewModel.libraryUiState.collectAsState()

    val screenType = if (windowSize == WindowWidthSizeClass.Expanded) {
        ScreenType.HORIZONTAL_SCREEN
    } else {
        ScreenType.VERTICAL_SCREEN
    }

    Scaffold(
        topBar = { LibraryTopBar() }
    ) {
        Surface(
            modifier = modifier.padding(it)
        ) {
            LibraryHomeScreen(
                libraryUiState = libraryUiState,
                libraryViewModel = libraryViewModel,
                screenType = screenType,
                modifier = Modifier.fillMaxSize()
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