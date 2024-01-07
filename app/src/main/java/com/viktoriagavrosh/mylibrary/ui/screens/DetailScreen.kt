package com.viktoriagavrosh.mylibrary.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoverBook(
            book = book
        )
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
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    MyLibraryTheme {
        DetailsScreen(
            book = Book("123", "fff", listOf("rrr"), 123),
            onUpdateHomeScreen = {  }
        )
    }
}