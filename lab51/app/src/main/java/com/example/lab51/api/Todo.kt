package com.example.lab51.api

data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    var completed: Boolean,
)
