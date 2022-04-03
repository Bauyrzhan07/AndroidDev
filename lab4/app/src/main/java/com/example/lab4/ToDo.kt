package com.example.lab4

import java.time.Duration

data class ToDo(
    val id: Int,
    val title: String,
    val description: String,
    val status: Boolean,
    val category: Category
)
