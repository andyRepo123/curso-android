package com.example.apprendevcurso

import android.app.Application
import androidx.room.Room
import com.example.apprendevcurso.data_persistence.EatsPreferences
import com.example.apprendevcurso.room_database.FoodDatabase


class EatsApp : Application() {
    companion object {
        lateinit var eatsPreferences: EatsPreferences
        lateinit var foodDatabase: FoodDatabase
    }

    override fun onCreate() {
        super.onCreate()
        eatsPreferences = EatsPreferences(applicationContext)
        foodDatabase = Room.databaseBuilder(
            applicationContext,
            FoodDatabase::class.java,
            "food-db"
        ).build()
    }
}