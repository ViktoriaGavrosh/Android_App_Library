package com.viktoriagavrosh.mylibrary.fake

import com.viktoriagavrosh.mylibrary.data.BooksRepository
import com.viktoriagavrosh.mylibrary.model.Book

class FakeNetworkBookRepository : BooksRepository {
    override suspend fun getBooks(text: String): List<Book> {
        return FakeDataSource.booksList
    }
}