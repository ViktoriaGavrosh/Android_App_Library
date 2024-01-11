package com.viktoriagavrosh.mylibrary.fake

import com.viktoriagavrosh.mylibrary.model.BookShelf
import com.viktoriagavrosh.mylibrary.network.LibraryApiService

class FakeApiService : LibraryApiService {

    override suspend fun getBooks(text: String, limit: Int): BookShelf {
        return FakeDataSource.bookShelf
    }
}