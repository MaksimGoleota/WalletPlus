package com.merio.walletplus.ui.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.merio.walletplus.MainActivity
import com.merio.walletplus.R
import com.merio.walletplus.data.PasswordStorage
import com.merio.walletplus.databinding.ActivityAuthorizationBinding

class AuthorizationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthorizationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        binding = ActivityAuthorizationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        signIn()
    }

    private fun signIn() = with(binding) {
        val password = PasswordStorage.getPassword()
        btnSignIn.setOnClickListener {
            if (password == editTextPassword.text.toString()) {
                Toast.makeText(
                    applicationContext,
                    R.string.logged_in,
                    Toast.LENGTH_SHORT
                )
                    .show()
                val intent = Intent(this@AuthorizationActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else
                Toast.makeText(
                    applicationContext,
                    R.string.invalid_data,
                    Toast.LENGTH_SHORT
                )
                    .show()
        }
    }
}