package com.example.apprendevcurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
    }

    fun goToHome(view: View) {
        if (loginValido()) {
            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("EMAIL", editTextEmail.text.toString())
            }
            startActivity(intent)
        } else {
            Toast.makeText(view.context, "Opcion 1", Toast.LENGTH_LONG).show()
        }
    }

    fun loginValido(): Boolean {
        if (editTextEmail.text.toString().isNotEmpty() && editTextPassword.text.toString()
                .isNotEmpty()
        ) {
            return true
        }

        return false
    }
}