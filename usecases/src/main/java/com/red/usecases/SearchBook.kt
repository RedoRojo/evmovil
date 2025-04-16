package com.red.usecases
import com.red.domain.Book

class SearchBook {
    fun invoke(query: String): List<Book> {
        return listOf(
            Book(
                authors = listOf("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"),
                title = "Design Patterns",
                publicationYear = 1994
            ))
    }
}