package com.example.game_catalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.game_catalogue.data.model.GameEntity
import com.example.game_catalogue.data.source.local.room.GameDao

class GameLocalRepository(private val gameDao: GameDao) {
    companion object {
        private var instance: GameLocalRepository? = null

        fun getInstance(gameDao: GameDao) = instance ?: synchronized(this) {
            instance ?: GameLocalRepository(gameDao)
        }
    }

    fun getFavouriteGames(): LiveData<List<GameEntity>> {
        val result = MutableLiveData<List<GameEntity>>()

        result.value = gameDao.getAllFavGames()

        return result
    }

    fun getGameById(id: Int): LiveData<GameEntity> {
        val result = MutableLiveData<GameEntity>()

        result.value = gameDao.getGameById(id)

        return result
    }
    fun insertGame(game: GameEntity) {
        gameDao.insertGame(game)
    }

    fun deleteGame(game: GameEntity) {
        gameDao.deleteGame(game)
    }
}