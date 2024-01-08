package com.viktoriagavrosh.mylibrary.data

import com.viktoriagavrosh.mylibrary.model.Book
import com.viktoriagavrosh.mylibrary.network.LibraryApiService

interface BooksRepository {
    suspend fun getBooks(): List<Book>
}

class NetworkBooksRepository(
    private val libraryApiService: LibraryApiService
) : BooksRepository {
    override suspend fun getBooks(): List<Book> {
        return libraryApiService.getBooks().books
    }
}