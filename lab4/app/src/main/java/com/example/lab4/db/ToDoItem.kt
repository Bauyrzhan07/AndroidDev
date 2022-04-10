package com.example.lab4.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = Category::class,
    parentColumns = ["id"],
    childColumns = ["category_id"])])
data class ToDoItem(
    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo val title: String,
    @ColumnInfo val description: String,
    @ColumnInfo val status: Boolean,
    @ColumnInfo(name = "category_id")
    val categoryId: Int,
    @ColumnInfo val duration: String
)
