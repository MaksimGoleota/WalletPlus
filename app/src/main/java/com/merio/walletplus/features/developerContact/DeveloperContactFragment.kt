package com.merio.walletplus.features.developerContact

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.merio.walletplus.R
import com.merio.walletplus.databinding.FragmentDeveloperContactBinding
import com.merio.walletplus.domain.DEVELOPER_EMAIL
import com.merio.walletplus.domain.sharedpreferences.PasswordStorage

class DeveloperContactFragment : Fragment() {

    private var _binding: FragmentDeveloperContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeveloperContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        getEserEmail()
        btnDeveloperContact.setOnClickListener {
            val subject = editTextMessageSubject.text.toString().trim()
            val email = DEVELOPER_EMAIL.trim()
            val message = editTextMessageText.text.toString().trim()
            checkEmptyField(subject, email, message)
        }
    }

    private fun getEserEmail() = with(binding) {
        val userEmail = PasswordStorage.getUserEmail()
        editTextUserEmail.setText(userEmail)
    }

    private fun checkEmptyField(subject: String, email: String, message: String) {
        if (subject.isNotEmpty() && email.isNotEmpty() && message.isNotEmpty()) {
            sendEmail(subject, email, message)
        } else {
            Toast.makeText(
                activity,
                R.string.fields_filled_out_incorrectly,
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }

    private fun sendEmail(subject: String, email: String, message: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        intent.putExtra(Intent.EXTRA_TEXT, message)
        intent.type = "message/rfc822"
        startActivity(Intent.createChooser(intent, R.string.choose_email_client.toString()))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}