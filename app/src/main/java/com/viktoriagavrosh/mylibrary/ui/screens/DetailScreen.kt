package com.viktoriagavrosh.mylibrary.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.viktoriagavrosh.mylibrary.R
import com.viktoriagavrosh.mylibrary.model.Book
import com.viktoriagavrosh.mylibrary.ui.theme.MyLibraryTheme

@Composable
fun DetailsScreen(
    book: Book,
    onUpdateHomeScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onUpdateHomeScreen()
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoverBook(
            book = book,
            modifier = Modifier
                .weight(3F)
                .padding(horizontal = dimensionResource(id = R.dimen.image_horizontal_padding))
        )
        Column(
            modifier = Modifier
                .weight(2F)
                .padding(dimensionResource(id = R.dimen.padding_large))
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = book.author.joinToString(),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = book.title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = "description",      // TODO book.description?????
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            )
        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    MyLibraryTheme {
        DetailsScreen(
            book = Book("123", "fff",123, listOf("rrr")),
            onUpdateHomeScreen = {  }
        )
    }
}