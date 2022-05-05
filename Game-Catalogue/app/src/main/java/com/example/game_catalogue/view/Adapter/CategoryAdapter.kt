package com.example.game_catalogue.view.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.game_catalogue.R
import com.example.game_catalogue.databinding.CategoryItemBinding
import com.example.game_catalogue.view.Fragment.CategoryListFragment
import com.example.game_catalogue.view.Fragment.GameListFragment
import com.example.game_catalogue.view.MainActivity

class CategoryAdapter(): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val categories = listOf("MMO", "MMORPG", "Shooter", "Social", "MOBA", "Fighting", "Strategy")

    inner class CategoryViewHolder(
        private val binding: CategoryItemBinding,
        val navController: NavController):
        RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(category: String) {
            binding.tvCategoryTitle.text = category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val navController = parent.findNavController()
        return CategoryViewHolder(binding, navController)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
        holder.itemView.setOnClickListener {
            holder.navController.navigate(
                R.id.action_categoryListFragment_to_gameListFragment,
                bundleOf(GameListFragment.ARG_MODE to 1, GameListFragment.ARG_CATEGORY to category)
            )
        }
    }

    override fun getItemCount() = categories.size
}