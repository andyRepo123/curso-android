package com.example.apprendevcurso.room_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.apprendevcurso.room_database.dao.FoodDao
import com.example.apprendevcurso.room_database.entities.FoodEntity

@Database(entities = [FoodEntity::class], version = 1)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
}