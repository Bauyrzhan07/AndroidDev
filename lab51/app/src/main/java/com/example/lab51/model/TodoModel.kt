package com.example.lab51.model

import android.util.Log
import com.example.lab51.api.ApiClient
import com.example.lab51.api.Todo
import com.example.lab51.contract.ContractInterface.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoModel: Model {

    override fun getData(id: Int): List<Any> {
        var result: List<Todo>? = null
        ApiClient.getApiService().getTodosByUserId(id).enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                result = if(response.isSuccessful) response.body()!! else emptyList()
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Log.e("TAG", t.message.toString())
            }

        })
        return result!!r 
    }
}