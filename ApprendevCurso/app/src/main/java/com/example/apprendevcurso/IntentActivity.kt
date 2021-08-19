package com.example.apprendevcurso

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.apprendevcurso.profile.Profile

class IntentActivity : AppCompatActivity() {
    private lateinit var profile: Profile
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        profile = Profile(
            profileId = "1",
            userName = "Andy",
            name = "Andrés",
            lastName = "Alemán",
            userDescription = "Amante de las tecnologías de la información"
        )
        Log.d(
            IntentActivity::class.java.simpleName,
            "onCreate()"
        )
    }

    override fun onStart() {
        super.onStart()
        Log.d(
            IntentActivity::class.java.simpleName,
            "onStart()"
        )
    }

    override fun onResume() {
        super.onResume()
        Log.d(
            IntentActivity::class.java.simpleName,
            "onResume()"
        )
    }

    override fun onPause() {
        super.onPause()
        Log.d(
            IntentActivity::class.java.simpleName,
            "onPause()"
        )
    }

    override fun onStop() {
        super.onStop()
        Log.d(
            IntentActivity::class.java.simpleName,
            "onStop()"
        )
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(
            IntentActivity::class.java.simpleName,
            "onRestart()"
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(
            IntentActivity::class.java.simpleName,
            "onDestroy()"
        )
    }

    fun navigateToWebApp(view: View) {
        /*val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.apprendev.com/")
        startActivity(intent)*/

        /*val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)*/

        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("Profile", profile)
        startActivity(intent)
    }
}