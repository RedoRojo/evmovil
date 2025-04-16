package com.red.usecases
import com.red.data.BookRepository
import com.red.domain.Book
class GetLikedBooks (
    val bookRepository: BookRepository
){
    suspend fun invoke(): List<Book> {
        return bookRepository.getLikedBooks()

    }
}