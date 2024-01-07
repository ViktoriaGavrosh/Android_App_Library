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
import com.viktoriagavrosh.mylibrary.R
import com.viktoriagavrosh.mylibrary.ui.screens.LibraryHomeScreen
import com.viktoriagavrosh.mylibrary.ui.theme.MyLibraryTheme

@Composable
fun LibraryApp(
    modifier: Modifier = Modifier
) {
    // TODO viewModel

    Scaffold(
        topBar = { LibraryTopBar() }
    ) {
        Surface(
           modifier = modifier.padding(it)
        ) {
            LibraryHomeScreen(
                //TODO uiState
                // TODO onBackPressed: viewModel.resetHomeScreenState()
                // TODO retryAction = viewModel.get???
                // TODO onBookClick = viewModel.goToDetailScreen()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LibraryTopBar(
    modifier: Modifier = Modifier
) {
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