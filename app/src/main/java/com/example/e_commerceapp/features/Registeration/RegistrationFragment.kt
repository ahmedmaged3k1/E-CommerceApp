package com.example.e_commerceapp.features.Registeration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentRegisterationBinding


class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegisterationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterationBinding.inflate(inflater, container, false)
        buttonOnClick()
        return binding.root
    }

    private fun buttonOnClick() {

        binding.confirmButton.setOnClickListener {
            if (validateLogin()) navigate(it)
        }

    }

    private fun validateLogin(): Boolean {
        if (binding.registrationName.text.isEmpty() || binding.registrationEmail.text.isEmpty() || binding.registrationPassword.text.isEmpty()) {
            val text = "Please Complete All Fields"
            val duration = Toast.LENGTH_SHORT
            val applicationContext = activity
            Toast.makeText(applicationContext, text, duration).show()

            return false
        }
        register()
        return true
    }

    private fun register() {

    }

    private fun navigate(view: View) {

        view.findNavController().navigate(R.id.action_registerationFragment_to_loginFragment)
    }

}