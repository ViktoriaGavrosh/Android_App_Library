package com.viktoriagavrosh.mylibrary.network

import com.viktoriagavrosh.mylibrary.model.BookShelf
import retrofit2.http.GET
import retrofit2.http.Query

interface LibraryApiService {

    @GET("search.json?")
    suspend fun getBooks(
        @Query("q") text: String,
        @Query("limit") limit: Int = 10
    ): BookShelf
}
