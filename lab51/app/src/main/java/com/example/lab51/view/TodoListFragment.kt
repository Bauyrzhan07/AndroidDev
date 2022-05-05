package com.example.lab51.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab51.R
import com.example.lab51.api.ApiClient
import com.example.lab51.databinding.FragmentTodoListBinding
import com.example.lab51.api.Todo
import com.example.lab51.view.Adapters.TodoAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoListFragment : Fragment(R.layout.fragment_todo_list) {
    private lateinit var binding: FragmentTodoListBinding
    private lateinit var todos: List<Todo>
    private var apiService = ApiClient.getApiService()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userName = requireArguments().getString(ARG_USER_NAME)
        val userId = requireArguments().getInt(ARG_USER_ID)

        todos = getTodos(userId)
        binding.apply {
            rvToDoList.adapter = TodoAdapter(todos)
            rvToDoList.layoutManager = LinearLayoutManager(context)

            tvUserName.text = userName

        }
    }

    private fun getTodos(id: Int): List<Todo> {
        var result: List<Todo> = emptyList()

        apiService.getTodosByUserId(id).enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                result = if(response.isSuccessful) response.body()!! else emptyList()
            }
            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Log.e("ERROR", t.message.toString())
            }
        })

        return result
    }

    companion object {
        const val ARG_USER_ID = "user_id"
        const val ARG_USER_NAME = "user_name"
    }
}