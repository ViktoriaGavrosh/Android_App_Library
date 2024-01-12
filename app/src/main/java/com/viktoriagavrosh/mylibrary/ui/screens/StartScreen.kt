package com.viktoriagavrosh.mylibrary.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.viktoriagavrosh.mylibrary.R
import com.viktoriagavrosh.mylibrary.ui.screens.viewmodel.LibraryUiState
import com.viktoriagavrosh.mylibrary.ui.theme.MyLibraryTheme

@Composable
fun StartScreen(
    libraryUiState: LibraryUiState,
    onTextFieldChange: (String) -> Unit,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.enter_request),
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center
        )
        OutlinedTextField(
            value = libraryUiState.textQuery,
            singleLine = true,
            onValueChange = onTextFieldChange,
            modifier = Modifier
                .padding(vertical = dimensionResource(id = R.dimen.start_screen_vertical_padding)),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Go
            ),
            keyboardActions = KeyboardActions(
                onGo = { onButtonClick() }
            )
        )
    }
}

@Preview
@Composable
fun StartScreenPreview() {
    MyLibraryTheme {
        StartScreen(
            libraryUiState = LibraryUiState(),
            onTextFieldChange = {},
            onButtonClick = {}
        )
    }
}