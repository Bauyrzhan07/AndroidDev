package com.example.lab4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.databinding.TodoItemBinding

class ToDoAdapter(
    var todos: List<ToDo>,
) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {
    private lateinit var itemBinding: TodoItemBinding
    inner class ToDoViewHolder(itemBinding: TodoItemBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        val layoutInflater = LayoutInflater.from(parent.context)
        itemBinding = TodoItemBinding.inflate(layoutInflater, parent, false)
        return ToDoViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.itemView.apply {
            itemBinding.tvCategory.text = todos[position].category.title
            itemBinding.tvTitle.text = todos[position].title
            itemBinding.cbDone.isChecked = todos[position].status
        }
    }
}