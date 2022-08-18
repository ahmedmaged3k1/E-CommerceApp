package com.example.e_commerceapp.ui.features.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.user = viewModel
        binding.lifecycleOwner = this
        validateLogin(binding.root)
        registerNavigation(binding.root)

        return binding.root
    }

    private fun registerNavigation(view: View) {
        binding.register.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_loginFragment_to_registerationFragment)
        }
    }

    private fun validateLogin(view: View) {
        viewModel.observer.observe(viewLifecycleOwner) {
            if (it == 2) {
                view.findNavController()
                    .navigate(
                        LoginFragmentDirections.actionLoginFragmentToNavigationFragment(
                            viewModel.confirmedUser
                        )
                    )
                binding.getStartedButton.isClickable = false
            }


        }

    }


}