package com.merio.walletplus.features.authorization.createuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import com.merio.walletplus.MainActivity
import com.merio.walletplus.R
import com.merio.walletplus.domain.sharedpreferences.PasswordStorage
import com.merio.walletplus.databinding.ActivityCreateUserBinding
import com.merio.walletplus.domain.database.User
import com.merio.walletplus.features.authorization.AuthorizationActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateUserBinding
    private val mViewModel: CreateUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
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
            if (editTextName.text.toString().isNotEmpty() &&
                editTextEmail.text.toString().isNotEmpty() &&
                editTextPassword.text.toString().isNotEmpty()
            ) {
                PasswordStorage.savePassword(
                    editTextName.text.toString(),
                    editTextEmail.text.toString(),
                    editTextPassword.text.toString(),
                )
                mViewModel.createUser(
                    User(
                        name = editTextName.text.toString(),
                        email = editTextEmail.text.toString(),
                        balance = editTextBalance.text.toString()
                    )
                )
                val intent = Intent(this@CreateUserActivity, MainActivity::class.java)
                startActivity(intent)
                finish()

                Toast.makeText(
                    applicationContext,
                    R.string.data_saved_successfully,
                    Toast.LENGTH_SHORT
                )
                    .show()

            } else {
                Toast.makeText(
                    applicationContext,
                    R.string.not_all_fields_are_filled,
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }
}