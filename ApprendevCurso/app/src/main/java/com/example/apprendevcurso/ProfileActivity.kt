package com.example.apprendevcurso

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apprendevcurso.databinding.ActivityProfileBinding
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType {
    BASIC,
    FACEBOOK
}

class ProfileActivity : AppCompatActivity() {
    private var _binding: ActivityProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.extras.let {
            val email = it?.getString("email") ?: ""
            val provider = it?.getString("provider") ?: ""
            saveCredentials(email, provider)
        }
    }

    private fun saveCredentials(email: String, provider: String) {
        val prefs =
            getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString("email", email)
        prefs.putString("provider", provider)
        prefs.apply()
        setUp(email, provider)
    }

    private fun setUp(email: String, provider: String) {
        title = "Perfil de usuario"
        binding.emailText.text = email
        binding.providerText.text = provider
        binding.signoutButton.setOnClickListener {
            val prefs =
                getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()
            FirebaseAuth.getInstance().signOut()
            if (provider == ProviderType.FACEBOOK.name) {
                LoginManager.getInstance().logOut()
            }
            onBackPressed()
        }
    }
}