package com.example.e_commerceapp.features.loginScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        getStartedButton()
        registerButton()
        return binding.root
    }
    private fun getStartedButton() {
        binding.getStartedButton.setOnClickListener {
            navigateLogin(it)
        }

    }
    private fun registerButton(){
        binding.register.setOnClickListener {
            navigateRegister(it)
        }
    }


    private fun navigateLogin(view: View) {

        view.findNavController().navigate(R.id.action_loginFragment_to_navigationFragment)
    }
    private fun navigateRegister(view: View) {

        view.findNavController().navigate(R.id.action_loginFragment_to_registerationFragment)
    }


}