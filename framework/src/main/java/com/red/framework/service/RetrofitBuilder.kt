package com.red.framework.service
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {
    private const val BASE_uRL = "https://openlibrary.org/"

    private fun getRetrofit(): Retrofit = Retrofit.Builder().baseUrl(BASE_uRL).addConverterFactory(MoshiConverterFactory.create()).build()

    val apiService: IApiService = getRetrofit().create(IApiService::class.java)
}