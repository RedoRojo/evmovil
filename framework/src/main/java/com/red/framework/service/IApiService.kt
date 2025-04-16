package com.red.framework.service

import com.red.framework.dto.BookListResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {
    @GET("search.json")
    suspend fun searchBook(@Query("q") title: String): BookListResponseDto
}