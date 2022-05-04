package com.example.lab51.view.Adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.lab51.R
import com.example.lab51.databinding.TodoItemBinding
import com.example.lab51.model.Todo

class TodoAdapter(
    private val todos: List<Todo>
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    private lateinit var binding: TodoItemBinding

    class TodoViewHolder(binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todos[position]

        holder.itemView.apply {
            binding.apply {
                tvTitle.text = todo.title
                cbDone.isChecked = todo.completed

                checkCb(holder, context)

                cbDone.setOnClickListener {
                    todo.completed = !todo.completed
                    checkCb(holder, context)
                }
            }
        }
    }

    private fun checkCb(holder: TodoViewHolder, context: Context) {
        holder.itemView.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (binding.cbDone.isChecked) {
                    binding.tvTitle.foreground =
                        ContextCompat.getDrawable(context, R.drawable.strike_through)
                } else {
                    binding.tvTitle.foreground = null
                }
            }
        }
    }
}