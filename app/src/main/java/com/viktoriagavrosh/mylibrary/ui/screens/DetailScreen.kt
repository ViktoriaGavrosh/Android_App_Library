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
import com.viktoriagavrosh.mylibrary.ui.theme.MyLibraryTheme

@Composable
fun DetailsScreen(
    // TODO book: Book
    // TODO onBackPressed: () -> Unit
    modifier: Modifier = Modifier
) {
    BackHandler {
        //onBackPressed()
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoverBook()
        Text(
            text = "author",      // TODO book.author
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "title",      // TODO book.title
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = "description",      // TODO book.description
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    MyLibraryTheme {
        DetailsScreen()
    }
}