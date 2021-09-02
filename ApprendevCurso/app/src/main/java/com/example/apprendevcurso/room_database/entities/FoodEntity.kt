package com.example.apprendevcurso.room_database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_entity")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var foodName: String = "",
    var foodDescription: String = "",
    var price: Double = 0.0
)
