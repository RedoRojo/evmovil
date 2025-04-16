package com.red.data.book

import com.red.domain.Book

interface IBookRemoteDataSource {
    suspend fun searchByTitle(title: String): List<Book>
}