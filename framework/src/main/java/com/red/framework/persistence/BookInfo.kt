package com.red.framework.persistence
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "books")
data class BookInfo (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val authors: String,
    val publicationYear: String
)