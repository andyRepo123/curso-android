package com.example.apprendevcurso.data_persistence

import android.content.Context
import android.content.SharedPreferences

const val PREFERENCES_NAME = "eats_preferences"
const val FOOD_NAME = "food_name"
const val PRICE_NAME = "price"
const val EMPTY_STRING = ""

class EatsPreferences(context: Context) {
    val eatsPreferences: SharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 0)

    var food: String
        get() = eatsPreferences.getString(FOOD_NAME, EMPTY_STRING) ?: EMPTY_STRING
        set(value) = eatsPreferences.edit().putString(FOOD_NAME, value).apply()

    var price: Float
        get() = eatsPreferences.getFloat(PRICE_NAME, 0f)
        set(value) = eatsPreferences.edit().putFloat(PRICE_NAME, value).apply()
}