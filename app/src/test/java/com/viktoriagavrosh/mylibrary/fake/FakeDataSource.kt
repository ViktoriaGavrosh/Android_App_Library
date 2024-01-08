package com.viktoriagavrosh.mylibrary.fake

import com.viktoriagavrosh.mylibrary.model.Book
import com.viktoriagavrosh.mylibrary.model.BookShelf

object FakeDataSource {

    private const val keyOne = "keyOne"
    private const val keyTwo = "keyTwo"
    private const val titleOne = "titleOne"
    private const val titleTwo = "titleTwo"
    private const val imgIdOne = 111
    private const val imgIdTwo = 222
    private val authorOne = listOf("authorOne")
    private val authorTwo = listOf("authorTwo")

    val booksList = listOf(
        Book(
            key = keyOne,
            title = titleOne,
            imgId = imgIdOne,
            author = authorOne
        ),
        Book(
            key = keyTwo,
            title = titleTwo,
            imgId = imgIdTwo,
            author = authorTwo
        )
    )

    val bookShelf = BookShelf(books = booksList)
}