package com.example.e_commerceapp.features.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentRegisterationBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegisterationBinding
    private val viewModel: RegistrationViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterationBinding.inflate(inflater, container, false)
        binding.user = viewModel
        binding.lifecycleOwner = this
        validateRegistration(binding.root)
        return binding.root
    }


    private fun validateRegistration(view: View) {
        viewModel.observer.observe(viewLifecycleOwner, Observer {
            if (it == 2)
            {
                view.findNavController()
                    .navigate(R.id.action_registerationFragment_to_loginFragment)
            }

        })

    }


}