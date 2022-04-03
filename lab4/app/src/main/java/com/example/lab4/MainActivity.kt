package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab4.databinding.ActivityMainBinding
import com.example.lab4.databinding.TodoItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bindingToDo: TodoItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var categories = listOf(
            Category(0, "first"),
            Category(1, "second")
        )
        var ToDoList = mutableListOf(
            ToDo(0, "a", "aaa", false, categories[0]),
            ToDo(1, "b", "bbb", false, categories[1]),
            ToDo(2, "c", "ccc", false, categories[1]),
            ToDo(3, "d", "ddd", false, categories[0])
        )

        val adapter = ToDoAdapter(ToDoList)
        binding.rvToDoList.adapter = adapter
        binding.rvToDoList.layoutManager = LinearLayoutManager(this)

        binding.btnApply.setOnClickListener {
            val title = binding.etNewTask.text.toString()
            ToDoList.add(ToDo(ToDoList.size, title, "", false, categories[0]))
            adapter.notifyItemInserted(ToDoList.size - 1)
        }
    }
}