package com.viktoriagavrosh.mylibrary.network

import com.viktoriagavrosh.mylibrary.model.BookShelf
import retrofit2.http.GET

interface LibraryApiService {

    @GET("search.json?q=fantasy&limit=10")
    suspend fun getBooks(): BookShelf
}