package com.viktoriagavrosh.mylibrary.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.viktoriagavrosh.mylibrary.R
import com.viktoriagavrosh.mylibrary.model.Book
import com.viktoriagavrosh.mylibrary.ui.theme.MyLibraryTheme

@Composable
fun LibraryHomeScreen(
    onUpdateHomeScreen: () -> Unit,
    modifier: Modifier = Modifier,
    libraryUiState: LibraryUiState,
    onBookClick: (Book, List<Book>) -> Unit,
    onBackPressed: (List<Book>) -> Unit
) {
    when (libraryUiState) {
        is LibraryUiState.Details -> {
            DetailsScreen(
                book = libraryUiState.book,
                bookList = libraryUiState.booksList,
                onBackPressed = onBackPressed,
                modifier = modifier.fillMaxSize()
            )
        }

        is LibraryUiState.Success -> {
            LibraryGridScreen(
                listBook = libraryUiState.booksList,
                modifier = modifier.fillMaxSize(),
                onBookClick = onBookClick
            )
        }

        is LibraryUiState.Loading -> {
            LoadingScreen(
                modifier = modifier.fillMaxSize()
            )
        }

        is LibraryUiState.Error -> {
            ErrorScreen(
                modifier = modifier.fillMaxSize(),
                onUpdateHomeScreen = onUpdateHomeScreen
            )
        }
    }
}

@Composable
private fun LibraryGridScreen(
    listBook: List<Book>,
    onBookClick: (Book, List<Book>) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.width_card_book)),
        modifier = modifier,
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_small))
    ) {
        items(items = listBook, key = { book -> book.key }) {
            CoverBook(
                book = it,
                modifier = Modifier
                    .clickable { onBookClick(it, listBook) }
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .aspectRatio(0.7F)
            )
        }
    }
}

@Composable
fun CoverBook(
    book: Book,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest
            .Builder(context = LocalContext.current)
            .data(book.imgUrl)
            .build(),
        contentDescription = book.title,
        error = painterResource(id = R.drawable.ic_broken_image),
        placeholder = painterResource(id = R.drawable.ic_autorenew),
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = Icons.Filled.Autorenew,
            contentDescription = stringResource(id = R.string.please_wait),
            modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size))
        )
        Text(
            text = stringResource(R.string.please_wait),
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_medium))
        )
    }
}

@Composable
private fun ErrorScreen(
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
private fun LibraryGridScreenPreview() {
    MyLibraryTheme {
        LibraryGridScreen(
            listBook = List(5) { Book("$it", "title", it, listOf("author")) },
            onBookClick = { _, _ ->  },
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun LoadingScreenPreview() {
    MyLibraryTheme {
        LoadingScreen()
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