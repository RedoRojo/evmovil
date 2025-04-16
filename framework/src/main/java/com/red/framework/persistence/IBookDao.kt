package com.red.framework.persistence
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface IBookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBook(bookInfo: BookInfo)
}