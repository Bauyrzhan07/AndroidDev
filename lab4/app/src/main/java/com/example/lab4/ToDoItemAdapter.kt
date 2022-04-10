package com.example.lab4

import android.content.Context
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.db.AppDatabase
import kotlinx.android.synthetic.main.todo_item.view.*

class ToDoItemAdapter(private val categoryId: Int) : RecyclerView.Adapter<ToDoItemAdapter.ToDoViewHolder>() {
    class ToDoViewHolder(view: View) : RecyclerView.ViewHolder(view)
    private var todoDao = ToDoApplication.instance.getDatabase().todoDao()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item, parent, false)
        return ToDoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoDao.getAllToDosByCategory(categoryId).size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val todos = todoDao.getAllToDosByCategory(categoryId)
        holder.itemView.apply {
            tvTitle.text = todos[position].title
            cbDone.isChecked = todos[position].status
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (cbDone.isChecked) {
                    tvTitle.foreground =
                        ContextCompat.getDrawable(context, R.drawable.strike_through)
                } else{
                    tvTitle.foreground = null
                }
            }
            cbDone.setOnClickListener{
                todoDao.updateStatus(cbDone.isChecked, todos[position].id)
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (cbDone.isChecked) {
                        tvTitle.foreground =
                            ContextCompat.getDrawable(context, R.drawable.strike_through)
                    } else{
                        tvTitle.foreground = null
                    }
                }
            }
            btnToDoDetails.setOnClickListener {
                val appCompatActivity = it.context as AppCompatActivity
                appCompatActivity.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view,
                        ToDoDetailFragment(todos[position].id),
                        null)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}