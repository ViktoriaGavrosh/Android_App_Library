package com.viktoriagavrosh.mylibrary.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookShelf(
    @SerialName(value = "docs")
    val books: List<Book>
)
