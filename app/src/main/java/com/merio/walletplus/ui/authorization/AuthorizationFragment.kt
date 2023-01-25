package com.merio.walletplus.ui.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.merio.walletplus.R
import com.merio.walletplus.data.PasswordStorage
import com.merio.walletplus.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment() {

    private var _binding: FragmentAuthorizationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        private val password = PasswordStorage.getPassword()
        checkingProfileCreation()
    }

    private fun checkingProfileCreation() = with(binding) {
        if (password.isEmpty()) {
            createProfile()
        } else
            findNavController().navigate(R.id.nav_home)
    }

    private fun createProfile() = with(binding) {
        btnCreateProfile.setOnClickListener {
            if (editTextTextPersonName.text.toString().isEmpty() &&
                editTextTextEmailAddress.text.toString().isEmpty()
            )
                Toast.makeText(
                    activity?.applicationContext,
                    R.string.no_password_entered_please_try_again,
                    Toast.LENGTH_SHORT
                ).show()
            else {
                PasswordStorage.savePassword(editTextTextPersonName.text.toString())
                PasswordStorage.savePassword(editTextTextEmailAddress.text.toString())
                Toast.makeText(
                    activity?.applicationContext,
                    R.string.password_saved_successfully,
                    Toast.LENGTH_SHORT
                ).show()

                findNavController().navigate(R.id.nav_home)
            }
        }
    }

}