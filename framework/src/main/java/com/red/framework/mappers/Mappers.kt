package com.red.framework.mappers

import com.red.domain.Book
import com.red.framework.dto.BookDto
import com.red.framework.dto.BookListResponseDto
import kotlin.math.atanh

fun BookDto.toModel(): Book {
    return Book(
        authors = authors,
        title = title,
        publicationYear = year
    )
}

fun BookListResponseDto.toModel(): List<Book> {
    return books.map { it.toModel() }
}