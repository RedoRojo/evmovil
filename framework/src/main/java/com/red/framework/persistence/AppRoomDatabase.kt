package com.red.framework.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [BookInfo::class], version =1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun bookDao() : IBookDao

    companion object {
        @Volatile
        private var Instance: AppRoomDatabase? = null
        fun getDatabase(context: Context): AppRoomDatabase{
            return Instance?: synchronized(this){
                Room.databaseBuilder( context, AppRoomDatabase ::class.java, "books_db" )
                    .build()
                    . also { Instance = it }
            }
        }

    }
}