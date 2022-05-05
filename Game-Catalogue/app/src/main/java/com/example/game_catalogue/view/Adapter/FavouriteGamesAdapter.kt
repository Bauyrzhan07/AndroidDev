package com.example.game_catalogue.view.Adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.game_catalogue.R
import com.example.game_catalogue.data.model.GameEntity
import com.example.game_catalogue.databinding.ItemGameCardBinding
import com.example.game_catalogue.viewModel.FavouritesViewModel

class FavouriteGamesAdapter(
    private val viewModel: FavouritesViewModel,
    private val onGameItemClicked: (position: Int, games: List<GameEntity>) -> Unit
): RecyclerView.Adapter<FavouriteGamesAdapter.FavGamesViewHolder>() {
    var games: MutableList<GameEntity> = emptyList<GameEntity>().toMutableList()

    class FavGamesViewHolder(
        private val binding: ItemGameCardBinding,
        private val viewModel: FavouritesViewModel,
        private val onGameItemClicked: (position: Int, games: List<GameEntity>) -> Unit,
        private val games: List<GameEntity>
    ): RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bind(game: GameEntity, adapter: FavouriteGamesAdapter) {
            binding.apply {
                tvTitle.text = game.title
                tvReleaseDate.text = "Released in:" + game.release_date
                tvShortDescription.text = game.short_description
                btnAction.text = binding.root.context.getString(R.string.delete_from_favs)
                btnAction.setOnClickListener {
                    Log.i("POS", absoluteAdapterPosition.toString())
                    viewModel.deleteGame(game)
                    Toast.makeText(
                        binding.root.context, "Successfully deleted!", Toast.LENGTH_SHORT
                    ).show()
                    adapter.updateData(absoluteAdapterPosition)
                }
            }
            Glide.with(binding.root)
                .load(game.thumbnail)
                .into(binding.imgPoster)
        }

        override fun onClick(p0: View?) {
            val position = absoluteAdapterPosition
            onGameItemClicked(position, games)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavGamesViewHolder {
        val binding = ItemGameCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavGamesViewHolder(binding, viewModel, onGameItemClicked, games)
    }

    override fun onBindViewHolder(holder: FavGamesViewHolder, position: Int) {
        val game = games[position]
        holder.bind(game, this)
    }

    override fun getItemCount() = games.size

    private fun updateData(position: Int) {
        games.removeAt(position)
        this.notifyItemRemoved(position)
    }
}