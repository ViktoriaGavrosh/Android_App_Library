package com.viktoriagavrosh.mylibrary.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.viktoriagavrosh.mylibrary.ui.utils.ScreenType

@Composable
fun DetailsScreen(
    book: Book,
    screenType: ScreenType,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBackPressed()
    }

    if (screenType == ScreenType.VERTICAL_SCREEN) {
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
    } else {
        Row(
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CoverBook(
                book = book,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_large))
            )
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(0.5F))
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
                Spacer(modifier = Modifier.weight(2F))
            }
        }
    }
}

@Preview
@Composable
fun CompactDetailsScreenPreview() {
    MyLibraryTheme {
        DetailsScreen(
            book = Book("123", "fff", 123, listOf("rrr")),
            screenType = ScreenType.VERTICAL_SCREEN,
            onBackPressed = { }
        )
    }
}

@Preview(widthDp = 1000)
@Composable
fun ExpandedDetailsScreenPreview() {
    MyLibraryTheme {
        DetailsScreen(
            book = Book("123", "fff", 123, listOf("rrr")),
            screenType = ScreenType.HORIZONTAL_SCREEN,
            onBackPressed = { }
        )
    }
}