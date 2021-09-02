package com.example.apprendevcurso.room_database.dao

import androidx.room.*
import com.example.apprendevcurso.room_database.entities.FoodEntity

@Dao
interface FoodDao {
    @Query("SELECT * FROM food_entity")
    fun getAllFood(): MutableList<FoodEntity>

    @Insert
    fun addFood(foodEntity: FoodEntity): Long

    @Update
    fun updateFood(foodEntity: FoodEntity): Int

    @Delete
    fun deleteFood(foodEntity: FoodEntity): Int
}