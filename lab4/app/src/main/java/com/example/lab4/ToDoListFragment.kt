package com.example.lab4

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.db.AppDatabase
import com.example.lab4.db.ToDoItem
import kotlinx.android.synthetic.main.fragment_to_do_list.*

class ToDoListFragment(private val categoryId: Int) : Fragment(R.layout.fragment_to_do_list) {
    private var adapter: RecyclerView.Adapter<ToDoItemAdapter.ToDoViewHolder>? = null
    private var todoDao = ToDoApplication.instance.getDatabase().todoDao()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_to_do_list, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        rvToDoList.layoutManager = LinearLayoutManager(activity)
        rvToDoList.adapter = ToDoItemAdapter(categoryId)
        btnApply.setOnClickListener {
            val title = etNewTask.text.toString()
            etNewTask.setText("")
            val size = todoDao.getAllToDos().size
            todoDao.insert(ToDoItem(0, title, "", false, categoryId, "Some date"))
            adapter?.notifyItemInserted(size - 1)
        }
    }
}