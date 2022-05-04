package com.example.lab51.api

import com.example.lab51.model.Todo
import com.example.lab51.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("users/")
    fun getUsers(): Call<List<User>>

    @GET("todos/")
    fun getTodosByUserId(@Query("userId") userId: Int): Call<List<Todo>>
}