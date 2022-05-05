package com.example.game_catalogue.viewModel

import androidx.lifecycle.ViewModel
import com.example.game_catalogue.data.source.local.GameLocalRepository
import com.example.game_catalogue.data.model.GameEntity

class FavouritesViewModel(private val gameLocalRepository: GameLocalRepository): ViewModel() {
    fun getAllFavouriteGame() = gameLocalRepository.getFavouriteGames()

    fun insertGame(game: GameEntity) {
        gameLocalRepository.insertGame(game)
    }

    fun deleteGame(game: GameEntity) {
        gameLocalRepository.deleteGame(game)
    }
}