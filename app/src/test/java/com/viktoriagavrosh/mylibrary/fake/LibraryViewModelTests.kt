package com.viktoriagavrosh.mylibrary.fake

import com.viktoriagavrosh.mylibrary.rule.TestDispatcherRule
import com.viktoriagavrosh.mylibrary.ui.screens.LibraryViewModel
import com.viktoriagavrosh.mylibrary.ui.utils.NavigationType
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class LibraryViewModelTests {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun libraryViewModel_verifyLibraryUiStateStart() = runTest {
        val libraryViewModel = LibraryViewModel(booksRepository = FakeNetworkBookRepository())
        assertEquals(
            NavigationType.Start,
            libraryViewModel.libraryUiState.value.navigationType
        )
    }

    @Test
    fun libraryViewModel_getBooksList_updateLibraryUiStateSuccess() = runTest {
        val libraryViewModel = LibraryViewModel(booksRepository = FakeNetworkBookRepository())
        libraryViewModel.updateTextQuery("")
        libraryViewModel.goToHomeScreen()
        assertEquals(
            NavigationType.Success,
            libraryViewModel.libraryUiState.value.navigationType
        )
    }
}