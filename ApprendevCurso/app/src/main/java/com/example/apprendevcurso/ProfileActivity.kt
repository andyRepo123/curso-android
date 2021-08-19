package com.example.apprendevcurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apprendevcurso.profile.Profile

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val profile = intent.getParcelableExtra<Profile>("Profile")
        Log.d(
            ProfileActivity::class.java.simpleName,
            "profileId = ${profile?.profileId}"
        )
        Log.d(
            ProfileActivity::class.java.simpleName,
            "userName = ${profile?.userName}"
        )
        Log.d(
            ProfileActivity::class.java.simpleName,
            "name = ${profile?.name}"
        )
        Log.d(
            ProfileActivity::class.java.simpleName,
            "lastName = ${profile?.lastName}"
        )
        Log.d(
            ProfileActivity::class.java.simpleName,
            "userDescription = ${profile?.userDescription}"
        )

        /**
         * Van asignar cada valor del Profile en un TextView deben ser un total
         * de 5 TextViews
         * Id Perfil: 1
         * Nombre de usuario: Andy
         */
    }
}