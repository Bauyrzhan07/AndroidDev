package com.example.lab4.db

import androidx.room.*

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todoitem WHERE category_id = :categoryId")
    fun getToDoByCategory(categoryId: Int): List<ToDoItem>;

    @Query("SELECT * FROM todoitem")
    fun getAllToDos(): List<ToDoItem>;

    @Query("SELECT * FROM todoitem WHERE category_id = :categoryId")
    fun getAllToDosByCategory(categoryId: Int): List<ToDoItem>

    @Query("SELECT * FROM todoitem WHERE id = :id")
    fun getToDoByID(id:Int): ToDoItem

    @Query("UPDATE todoitem SET title = :title WHERE id = :id")
    fun updateTitle(title: String, id: Int)

    @Query("UPDATE todoitem SET description = :description WHERE id = :id")
    fun updateDescription(description: String, id: Int)

    @Query("UPDATE todoitem SET status = :status WHERE id = :id")
    fun updateStatus(status: Boolean, id: Int)

    @Insert
    fun insert(todo: ToDoItem);

    @Delete
    fun delete(todo: ToDoItem)
}