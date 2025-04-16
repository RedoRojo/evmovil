package com.red.data

import com.red.data.book.IBookRemoteDataSource
import com.red.data.book.IBookLocalDataSource
import com.red.domain.Book

class BookRepository (
    val bookRemoteDataSource: IBookRemoteDataSource,
    val bookLocalDataSource: IBookLocalDataSource
){
    suspend fun searchByTitle(title: String): List<Book> {
        return bookRemoteDataSource.searchByTitle(title)
    }

    suspend fun saveBook(book: Book): Boolean {
        bookLocalDataSource.saveBook(book)
        return true;
    }
}