package com.viktoriagavrosh.mylibrary.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.viktoriagavrosh.mylibrary.R
import com.viktoriagavrosh.mylibrary.ui.theme.MyLibraryTheme

@Composable
fun LibraryHomeScreen(
    // TODO onBackPressed: () -> Unit
    modifier: Modifier = Modifier
    // TODO uiState
    // TODO retryAction: () -> Unit
    // TODO onBookClick: ( Book ) -> Unit
) {
    // TODO when(uiState)
    DetailsScreen(
        // TODO onBackPressed: () -> Unit
        modifier = modifier.fillMaxSize()
    )
    LibraryGridScreen(
        modifier = modifier.fillMaxSize()
        // TODO onBookClick = onBookClick
    )
    LoadingScreen(
        modifier = modifier.fillMaxSize()
    )
    ErrorScreen(
        modifier = modifier.fillMaxSize()
        // TODO retryAction = retryAction
    )
}

@Composable
private fun LibraryGridScreen(
    // TODO listBook: List<Book>
    // TODO onBookClick: ( Book ) -> Unit
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.width_card_book)),
        modifier = modifier,
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_small))
    ) {
        // items(items= listBook, key = {  }) { CoverBook(
        // modifier = Modifier.clickable { onBookClick(it) }) }
        items(items = listOf(1, 2, 3, 4, 5)) {
            Image(
                painter = painterResource(id = R.drawable.flaffy),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun CoverBook(
    //book: Book
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest
            .Builder(context = LocalContext.current)
            .data("")   // book.imgUrl
            .build(),
        contentDescription = null, // book.title
        error = painterResource(id = R.drawable.ic_broken_image),
        placeholder = painterResource(id = R.drawable.ic_autorenew),
        modifier = Modifier.fillMaxWidth()
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
    modifier: Modifier = Modifier
    // TODO retryAction: () -> Unit
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
            onClick = { // TODO retryAction + delete{
                 },
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
        LibraryGridScreen(modifier = Modifier.fillMaxSize())
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
        ErrorScreen()
    }
}