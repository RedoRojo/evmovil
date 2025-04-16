package com.red.usecases
import com.red.domain.Book
import com.red.data.BookRepository
import kotlinx.coroutines.delay

class SearchBook (
    val bookRepository: BookRepository
){
    suspend fun invoke(title: String): List<Book> {
        delay(200)
        return bookRepository.searchByTitle(title)
    }
}