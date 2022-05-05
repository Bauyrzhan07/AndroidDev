package com.example.game_catalogue.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.game_catalogue.data.model.Game

@Entity(tableName = "favourite_games")
class GameEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "image")
    val thumbnail: String,

    @ColumnInfo(name = "short_description")
    val short_description: String,

    @ColumnInfo(name = "genre")
    val genre: String,

    @ColumnInfo(name = "platform")
    val platform: String,

    @ColumnInfo(name = "release_date")
    val release_date: String,

    @ColumnInfo(name = "url")
    val freetogame_profile_url: String,

    @ColumnInfo(name = "is_favourite")
    val is_fav: Boolean
) {
    constructor(game: Game): this(
        game.id, game.title, game.thumbnail, game.short_description,
        game.genre, game.platform, game.release_date, game.freetogame_profile_url, game.is_fav
    )
}