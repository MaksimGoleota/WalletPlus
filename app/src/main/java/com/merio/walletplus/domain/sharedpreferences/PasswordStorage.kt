package com.merio.walletplus.domain.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

object PasswordStorage {

    private const val NAME = "PasswordStorage"
    private const val MODE = Context.MODE_PRIVATE
    private var preferences: SharedPreferences? = null
    private const val USER_NAME = "name"
    private const val USER_EMAIL = "email"
    private const val USER_PASSWORD = "password"

    fun init(context: Context) {
        preferences = context.getSharedPreferences(
            NAME,
            MODE
        )
    }


    fun savePassword(newName: String, newEmail: String, newPassword: String) {
        val editor = preferences?.edit()
        if (editor != null) {
            editor.putString(USER_NAME, newName)
            editor.putString(USER_EMAIL, newEmail)
            editor.putString(USER_PASSWORD, newPassword)
            editor.apply()
        }
    }
    fun getUserName(): String = preferences?.getString(USER_NAME, "") ?: ""
    fun getUserEmail(): String = preferences?.getString(USER_EMAIL, "") ?: ""
    fun getPassword(): String = preferences?.getString(USER_PASSWORD, "") ?: ""

//    fun deletePassword() {
//        val editor = preferences?.edit()
//        if (editor != null) {
//            editor.clear()
//            editor.apply()
//        }
//    }
}
