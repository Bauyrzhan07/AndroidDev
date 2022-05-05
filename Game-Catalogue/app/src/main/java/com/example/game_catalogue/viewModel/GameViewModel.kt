package com.example.game_catalogue.viewModel

import androidx.lifecycle.ViewModel
import com.example.game_catalogue.data.source.local.GameLocalRepository
import com.example.game_catalogue.data.model.GameEntity
import com.example.game_catalogue.data.source.remote.GameRemoteRepository

class GameViewModel(
    private val gameRepository: GameRemoteRepository,
    private val gameLocalRepository: GameLocalRepository
): ViewModel() {
    fun getAllGames() = gameRepository.getAllGames()

    fun getGamesByCategory(category: String) = gameRepository.getGamesByCategoryName(category)

    fun getGameById(id: Int) = gameLocalRepository.getGameById(id)

    fun insertGame(game: GameEntity) {
        gameLocalRepository.insertGame(game)
    }

    fun deleteGame(game: GameEntity) {
        gameLocalRepository.deleteGame(game)
    }
}