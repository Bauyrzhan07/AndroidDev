package com.example.lab51.view.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lab51.R
import com.example.lab51.databinding.UserItemBinding
import com.example.lab51.api.User
import com.example.lab51.view.TodoListFragment

class UserAdapter(
    private val users: List<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private lateinit var binding: UserItemBinding

    class UserViewHolder(binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        binding =  UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.itemView.apply {
            binding.apply {
                tvUserName.text = user.name
                UserTodos.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_usersFragment_to_todoListFragment,
                        bundleOf(
                            TodoListFragment.ARG_USER_ID to user.id,
                            TodoListFragment.ARG_USER_NAME to user.name)
                    )
                }
            }
        }
    }
}