package com.example.lab4

import android.content.Context
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab4.db.AppDatabase
import kotlinx.android.synthetic.main.fragment_to_do_detail.*
import kotlinx.android.synthetic.main.todo_item.tvTitle

class ToDoDetailFragment(val todoId: Int ) : Fragment() {
    private var todoDao = ToDoApplication.instance.getDatabase().todoDao()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_to_do_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var todo = todoDao.getToDoByID(todoId)
        etTitle.setText(todo.title)
        val txt = todo.description
        if(txt != "")
            etDescription.setText(todo.description)
        tvDuration.text = todo.duration
        status.isChecked = todo.status
        btnSave.setOnClickListener {
            todoDao.updateTitle(etTitle.text.toString(), todoId)
            todoDao.updateDescription(etDescription.text.toString(), todoId)
            todoDao.updateStatus(status.isChecked, todoId)
        }
    }
}