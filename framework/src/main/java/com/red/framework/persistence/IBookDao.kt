package com.red.framework.persistence
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IBookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBook(bookInfo: BookInfo)

    @Query("SELECT * FROM books")
    suspend fun getLikedBooks(): List<BookInfo>
}