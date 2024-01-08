package com.viktoriagavrosh.mylibrary.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.viktoriagavrosh.mylibrary.network.LibraryApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val booksRepository: BooksRepository
}

class DefaultAppContainer : AppContainer {

    private val baseUrl = "https://openlibrary.org"

    private val retrofit = Retrofit
        .Builder()
        .addConverterFactory(
            Json{ ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: LibraryApiService by lazy {
        retrofit.create(LibraryApiService::class.java)
    }

    override val booksRepository: BooksRepository by lazy {
        NetworkBooksRepository(retrofitService)
    }
}