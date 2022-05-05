package com.example.game_catalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.game_catalogue.data.model.Game
import com.example.game_catalogue.data.source.remote.Api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GameRemoteRepository() {
    companion object {
        private var instance: GameRemoteRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: GameRemoteRepository()
        }
    }

    fun getAllGames(): LiveData<List<Game>> {
        val result = MutableLiveData<List<Game>>()

        val call = ApiClient.getApiService()?.getAllGames()
        call?.enqueue(object : Callback<List<Game>> {
            override fun onResponse(call: Call<List<Game>>, response: Response<List<Game>>) {
                result.value = if (response.isSuccessful) response.body() else emptyList()
            }
            override fun onFailure(call: Call<List<Game>>, t: Throwable) {
                result.value = emptyList()
                Log.i("Error", t.message.toString())
            }
        })

        return result
    }

    fun getGamesByCategoryName(category: String): LiveData<List<Game>> {
        val result = MutableLiveData<List<Game>>()

        val call = ApiClient.getApiService()?.getGamesByCategory(category)
        call?.enqueue(object : Callback<List<Game>> {
            override fun onResponse(call: Call<List<Game>>, response: Response<List<Game>>) {
                result.value = if (response.isSuccessful) response.body() else emptyList()
            }
            override fun onFailure(call: Call<List<Game>>, t: Throwable) {
                result.value = emptyList()
                Log.i("Error", t.message.toString())
            }
        })

        return result
    }
}