package com.red.evmovil.di

import android.content.Context
import com.red.data.BookRepository
import com.red.data.book.IBookLocalDataSource
import com.red.data.book.IBookRemoteDataSource
import com.red.framework.service.RetrofitBuilder
import com.red.framework.book.BookRemoteDataSource
import com.red.framework.book.BookLocalDataSource
import com.red.usecases.GetLikedBooks
import com.red.usecases.LikeBook
import com.red.usecases.SearchBook
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofitBuilder(): RetrofitBuilder = RetrofitBuilder

    @Provides
    @Singleton
    fun provideBookRemoteDataSource(retrofitBuilder: RetrofitBuilder): IBookRemoteDataSource {
        return BookRemoteDataSource(retrofitBuilder)
    }

    @Provides
    @Singleton
    fun provideBookLocalDataSource(@ApplicationContext context: Context): IBookLocalDataSource {
        return BookLocalDataSource(context)
    }

    @Provides
    @Singleton
    fun provideBookRepository(remoteDataSource: IBookRemoteDataSource, localDataSource: IBookLocalDataSource): BookRepository {
        return BookRepository(remoteDataSource, localDataSource)
    }

    @Provides
    @Singleton
    fun provideSearchBook(repository: BookRepository): SearchBook {
        return SearchBook(repository)
    }

    @Provides
    @Singleton
    fun provideLikeBook(repository: BookRepository): LikeBook {
        return LikeBook(repository)
    }

    @Provides
    @Singleton
    fun provideGetLikedBooks(repository: BookRepository): GetLikedBooks {
        return GetLikedBooks(repository)
    }


}