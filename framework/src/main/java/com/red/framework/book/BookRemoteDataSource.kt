package com.red.framework.book

import com.red.domain.Book
import com.red.data.book.IBookRemoteDataSource
import com.red.framework.service.RetrofitBuilder
import com.red.framework.mappers.toModel

class BookRemoteDataSource (
    val retrofitService: RetrofitBuilder
) : IBookRemoteDataSource {
    override suspend fun searchByTitle(title: String): List<Book> {
        return retrofitService.apiService.searchBook(title).toModel()
    }
}