package com.merio.walletplus.ui.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.merio.walletplus.MainActivity
import com.merio.walletplus.R
import com.merio.walletplus.data.PasswordStorage
import com.merio.walletplus.databinding.ActivityCreateUserBinding

class CreateUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val password = PasswordStorage.getPassword()
        if (password.isEmpty()) {
            createProfile()
        } else {
            val intent = Intent(this@CreateUserActivity, AuthorizationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun createProfile() = with(binding) {
        btnCreateProfile.setOnClickListener {
            if (editTextPersonName.text.toString().isEmpty() &&
                editTextEmailAddress.text.toString().isEmpty() &&
                editTextPassword.text.toString().isEmpty()
            ) {
                Toast.makeText(
                    applicationContext,
                    R.string.not_all_fields_are_filled,
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                PasswordStorage.savePassword(
                    editTextPersonName.text.toString(),
                    editTextEmailAddress.text.toString(),
                    editTextPassword.text.toString(),
                )
                val intent = Intent(this@CreateUserActivity, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(
                    applicationContext,
                    R.string.data_saved_successfully,
                    Toast.LENGTH_SHORT
                )
                    .show()

            }
        }
    }
}