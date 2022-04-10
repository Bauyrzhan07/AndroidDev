package com.example.lab4.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category WHERE id = :categoryId")
    fun getCategoryByID(categoryId: Int): Category

    @Query("SELECT COUNT(*) FROM (SELECT * FROM todoitem WHERE category_id = :categoryId)")
    fun getCategoryItemCount(categoryId: Int): Int

    @Query("SELECT * FROM category")
    fun getAllCategories(): List<Category>;

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(category: Category);
}