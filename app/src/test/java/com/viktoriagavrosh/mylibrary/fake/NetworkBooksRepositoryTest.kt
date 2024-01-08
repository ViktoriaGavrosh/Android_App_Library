package com.viktoriagavrosh.mylibrary.fake

import com.viktoriagavrosh.mylibrary.data.NetworkBooksRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkBooksRepositoryTest {

    @Test
    fun networkBooksRepository_getBooks_verifyBooksList() = runTest {
        val repository = NetworkBooksRepository(libraryApiService = FakeApiService())
        assertEquals(
            FakeDataSource.booksList,
            repository.getBooks()
        )
    }
}