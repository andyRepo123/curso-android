package com.example.apprendevcurso

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
            setUp(
                it?.getString("email") ?: "",
                it?.getString("provider") ?: ""
            )
        }
    }

    private fun setUp(email: String, provider: String) {
        title = "Perfil de usuario"
        binding.emailText.text = email
        binding.providerText.text = provider
        binding.signoutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            if (provider == ProviderType.FACEBOOK.name) {
                LoginManager.getInstance().logOut()
            }
            onBackPressed()
        }
    }
}