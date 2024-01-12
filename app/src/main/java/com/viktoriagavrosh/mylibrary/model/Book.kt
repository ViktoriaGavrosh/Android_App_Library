package com.viktoriagavrosh.mylibrary.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Book(
    val key: String,
    val title: String,
    @SerialName(value = "cover_i")
    val imgId: Int = 0,
    @SerialName(value = "author_name")
    val author: List<String>,
) {
    var imgUrl: String = "https://covers.openlibrary.org/a/id/${imgId}.jpg"
}