package com.example.lab4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.db.AppDatabase
import kotlinx.android.synthetic.main.category.view.*

class CategoryAdapter() : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val categoryDao = ToDoApplication.instance.getDatabase().categoryDao()

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryDao.getAllCategories().size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryDao.getCategoryByID(position + 1)
        holder.itemView.apply {
            tvCategoryTitle.text = category.title
            tvItemCount.text = categoryDao.getCategoryItemCount(category.id).toString()
            CategoryTodos.setOnClickListener {
                val appCompatActivity = it.context as AppCompatActivity
                appCompatActivity.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, ToDoListFragment(category.id), null)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}