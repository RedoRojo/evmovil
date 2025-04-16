package com.red.data.book
import com.red.domain.Book

interface IBookLocalDataSource {
    suspend fun saveBook(book: Book): Boolean
    suspend fun getLikedBooks(): List<Book>

}