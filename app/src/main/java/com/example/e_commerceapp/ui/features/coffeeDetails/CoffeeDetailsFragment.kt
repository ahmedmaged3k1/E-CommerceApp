package com.example.e_commerceapp.ui.features.coffeeDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentCoffeeDetailsBinding
import com.example.e_commerceapp.ui.features.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoffeeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentCoffeeDetailsBinding
    private val args by navArgs<CoffeeDetailsFragmentArgs>()
    private val sharedViewModel: LoginViewModel by activityViewModels()
    private val viewModel: CoffeeDetailsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoffeeDetailsBinding.inflate(inflater, container, false)

        binding.coffee = viewModel
        viewModel.coffeeItem = args.coffee
        viewModel.coffeeCart.userName = sharedViewModel.confirmedUser.userName.toString()
        binding.lifecycleOwner = this
        backButton(binding.root)
        goToCart(binding.root)
        return binding.root
    }


    private fun backButton(view: View) {
        binding.backButton.setOnClickListener(View.OnClickListener {
            view.findNavController()
                .navigate(R.id.action_coffeeDetailsFragment_to_navigationFragment)
        })

    }

    private fun goToCart(view: View) {

        viewModel.observer.observe(viewLifecycleOwner, Observer {
            if (it == 2) {
                view.findNavController()
                    .navigate(R.id.action_coffeeDetailsFragment_to_navigationFragment)
                binding.addToCart.isClickable = false
            }
        })

    }
}



