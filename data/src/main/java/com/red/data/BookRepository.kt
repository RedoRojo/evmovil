package com.red.data

import com.red.data.book.IBookRemoteDataSource
import com.red.domain.Book

class BookRepository (
    val bookRemoteDataSource: IBookRemoteDataSource
){
    suspend fun searchByTitle(title: String): List<Book> {
        return bookRemoteDataSource.searchByTitle(title)
    }
}