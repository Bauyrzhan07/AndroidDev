package com.example.game_catalogue.view.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.game_catalogue.R
import com.example.game_catalogue.databinding.FragmentCategoryListBinding
import com.example.game_catalogue.view.Adapter.CategoryAdapter

class CategoryListFragment : Fragment(R.layout.fragment_category_list) {
    private lateinit var binding: FragmentCategoryListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCategoryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvCategoryList.adapter = CategoryAdapter()
            rvCategoryList.layoutManager = LinearLayoutManager(context)
        }
    }
}