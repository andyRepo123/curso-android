package com.example.apprendevcurso.room_database.ui.adapters

import com.example.apprendevcurso.room_database.entities.FoodEntity

interface FoodActions {
    fun getFood(foodEntity: FoodEntity)
}