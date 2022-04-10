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
import com.example.lab4.db.Category
import kotlinx.android.synthetic.main.fragment_categories.*

class CategoriesFragment() : Fragment(R.layout.fragment_categories) {
    private var adapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>? = null
    private var categoryDao = ToDoApplication.instance.getDatabase().categoryDao()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        rvCategoryList.layoutManager = LinearLayoutManager(activity)
        rvCategoryList.adapter = CategoryAdapter()
        btnAddCategory.setOnClickListener {
            val title = etNewCategory.text.toString()
            etNewCategory.setText("")
            val size = categoryDao.getAllCategories().size
            val newCat = Category(0, title)
            categoryDao.insert(newCat)
            adapter?.notifyItemInserted(size - 1)
            Log.e("Category", size.toString())
            Log.e("Category", categoryDao.getCategoryByID(size + 1).title)
        }
    }
}