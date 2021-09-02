package com.example.apprendevcurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.apprendevcurso.databinding.ActivityProfileBinding
import com.example.apprendevcurso.profile.Profile

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        showEats()
    }

    private fun showEats() {
        EatsApp.eatsPreferences.let {
            with(binding) {
                this.food.text = it.food
                this.price.text = it.price.toString()
            }
        }
    }
}