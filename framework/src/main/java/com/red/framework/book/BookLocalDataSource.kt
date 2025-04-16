package com.red.framework.book
import android.content.Context
import com.red.data.book.IBookLocalDataSource
import com.red.domain.Book
import com.red.framework.mappers.toEntity
import com.red.framework.persistence.AppRoomDatabase

class BookLocalDataSource (val context: Context) : IBookLocalDataSource {
    val bookDao = AppRoomDatabase.getDatabase(context).bookDao()
    override suspend fun saveBook(book: Book): Boolean {
        bookDao.saveBook(book.toEntity())
        return true
    }
}