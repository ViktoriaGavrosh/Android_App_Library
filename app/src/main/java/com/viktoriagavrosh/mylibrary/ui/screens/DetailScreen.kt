package com.viktoriagavrosh.mylibrary.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
    bookList: List<Book>,
    onBackPressed: (List<Book>) -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBackPressed(bookList)
    }

    Column(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.5F))
        CoverBook(
            book = book,
            modifier = Modifier
                .weight(3F)
        )
        Text(
            text = book.author.joinToString(),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(
                top = dimensionResource(id = R.dimen.padding_large)
            )
        )
        Text(
            text = book.title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.weight(0.5F))
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    MyLibraryTheme {
        DetailsScreen(
            book = Book("123", "fff", 123, listOf("rrr")),
            bookList = emptyList(),
            onBackPressed = { }
        )
    }
}