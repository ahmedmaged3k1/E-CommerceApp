package com.example.e_commerceapp.features.loginScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentLoginBinding
import com.example.e_commerceapp.databinding.FragmentOnBoardingBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        buttonOnClick()
        return binding.root
    }
    private fun buttonOnClick() {
        binding.getStartedButton.setOnClickListener {
            navigate(it)
        }

    }

    private fun navigate(view: View) {

        view.findNavController().navigate(R.id.action_loginFragment_to_navigationFragment)
    }


}