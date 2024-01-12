package com.viktoriagavrosh.mylibrary.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.viktoriagavrosh.mylibrary.R
import com.viktoriagavrosh.mylibrary.model.Book
import com.viktoriagavrosh.mylibrary.ui.theme.MyLibraryTheme


@Composable
fun LibraryGridScreen(
    listBook: List<Book>,
    onBookClick: (Book) -> Unit,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit
) {
    BackHandler {
        onBackPressed()
    }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.width_card_book)),
        modifier = modifier,
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_small))
    ) {
        items(items = listBook, key = { book -> book.key }) {
            CoverBook(
                book = it,
                isContentScaleCrop = true,
                modifier = Modifier
                    .clickable { onBookClick(it) }
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small))

            )
        }
    }
}

@Composable
fun CoverBook(
    book: Book,
    isContentScaleCrop: Boolean,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest
            .Builder(context = LocalContext.current)
            .data(book.imgUrl)
            .build(),
        contentDescription = book.title,
        error = painterResource(id = R.drawable.default_cover_book),
        placeholder = painterResource(id = R.drawable.default_cover_book),
        modifier = modifier
            .aspectRatio(0.65F),
        contentScale = if(isContentScaleCrop) ContentScale.Crop else ContentScale.Fit
    )
}


@Preview
@Composable
private fun LibraryGridScreenPreview() {
    MyLibraryTheme {
        LibraryGridScreen(
            listBook = List(5) { Book("$it", "title", it, listOf("author")) },
            onBookClick = { _ -> },
            modifier = Modifier.fillMaxSize(),
            onBackPressed = {}
        )
    }
}
