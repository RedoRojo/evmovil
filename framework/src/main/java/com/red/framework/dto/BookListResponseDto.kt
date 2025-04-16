package com.red.framework.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookListResponseDto (
    @Json(name = "docs")
    var books: List<BookDto>
)