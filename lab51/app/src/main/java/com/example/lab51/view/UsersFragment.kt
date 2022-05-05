package com.example.lab51.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab51.view.Adapters.UserAdapter
import com.example.lab51.R
import com.example.lab51.api.ApiClient
import com.example.lab51.contract.ContractInterface
import com.example.lab51.databinding.FragmentUsersBinding
import com.example.lab51.api.User
import com.example.lab51.presenter.TodoListFragmentPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersFragment : Fragment(R.layout.fragment_users), ContractInterface.View {
    private lateinit var binding: FragmentUsersBinding
    private lateinit var users: List<User>
    private var apiService = ApiClient.getApiService()
    private var presenter: TodoListFragmentPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = TodoListFragmentPresenter(this)
        users = getUsers()
        initView()

    }

    override fun initView() {
        binding.rvUserList.apply {
            adapter = UserAdapter(users)
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun updateViewData() {
        binding.rvUserList.adapter = UserAdapter(users)
    }
    private fun getUsers(): List<User> {
        var result: List<User> = emptyList()

        apiService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                result = if (response.isSuccessful) response.body()!! else emptyList()
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("ERROR", t.message.toString())
            }
        })

        return result
    }
}