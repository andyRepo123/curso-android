package com.example.apprendevcurso.room_database.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apprendevcurso.R

class FoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FoodFragment())
                .commitNow()
        }
    }
}