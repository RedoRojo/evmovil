package com.red.framework.mappers

import com.red.domain.Book
import com.red.framework.dto.BookDto
import com.red.framework.dto.BookListResponseDto
import com.red.framework.persistence.BookInfo
import kotlin.math.atanh

fun BookDto.toModel(): Book {
    return Book(
        authors = authors?: listOf("Anonimo"),
        title = title?: "Sin titulo",
        publicationYear = year?.toString() ?: "Anio desconocido"
    )
}

fun BookListResponseDto.toModel(): List<Book> {
    return books.map { it.toModel() }
}

fun Book.toEntity(): BookInfo {
    return BookInfo(
        title = this.title,
        authors = this.authors.joinToString(),
        publicationYear = this.publicationYear
    )
}

fun BookInfo.toDomain(): Book {
    return Book(
        title = this.title,
        authors = this.authors.split(",").map { it.trim() },
        publicationYear = this.publicationYear
    )
}