package com.example.game_catalogue.data.source.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.game_catalogue.data.model.GameEntity

@Dao
interface GameDao {
    @Query("SELECT * FROM favourite_games")
    fun getAllFavGames(): List<GameEntity>

//    @Query("UPDATE favourite_games SET is_favourite = :value WHERE id = :id")
//    fun updateFavGames(value: Boolean, id: Int)
    @Query("SELECT * FROM favourite_games WHERE id = :id")
    fun getGameById(id: Int): GameEntity?

    @Insert
    fun insertGame(game: GameEntity)

    @Delete
    fun deleteGame(game: GameEntity)
}