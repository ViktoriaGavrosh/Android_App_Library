package com.viktoriagavrosh.mylibrary.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.viktoriagavrosh.mylibrary.R
import com.viktoriagavrosh.mylibrary.ui.theme.MyLibraryTheme


@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    onUpdateHomeScreen: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = Icons.Filled.CloudOff,
            contentDescription = stringResource(R.string.no_internet),
            modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size))
        )
        Text(
            text = stringResource(R.string.no_internet),
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_medium))
        )
        Button(
            onClick = { onUpdateHomeScreen() },
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.button_top_padding))
        ) {
            Text(
                text = stringResource(R.string.try_again),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview
@Composable
private fun ErrorScreenPreview() {
    MyLibraryTheme {
        ErrorScreen(
            onUpdateHomeScreen = {}
        )
    }
}