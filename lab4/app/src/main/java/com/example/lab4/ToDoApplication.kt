package com.example.lab4

import android.app.Application
import com.example.lab4.db.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ToDoApplication: Application() {
    private lateinit var database: AppDatabase

    companion object {
        lateinit var instance: ToDoApplication
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        database = AppDatabase.getInstance(this)
    }

    fun getDatabase():AppDatabase{
        return database
    }
}