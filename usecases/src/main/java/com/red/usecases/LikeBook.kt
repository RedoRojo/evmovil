package com.red.usecases

import com.red.data.BookRepository
import com.red.domain.Book

class LikeBook(
    val bookRepository: BookRepository
){
    suspend fun invoke(book: Book) {
        bookRepository.saveBook(book)
    }
}