package com.example.apprendevcurso.food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apprendevcurso.EatsApp
import com.example.apprendevcurso.ProfileActivity
import com.example.apprendevcurso.R

class EatsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eats)
    }

    fun navigateToProfile(view: android.view.View) {
        EatsApp.eatsPreferences.apply {
            this.food = "Pollo"
            this.price = 40.50f
        }
        startActivity(Intent(view.context, ProfileActivity::class.java))
    }
}