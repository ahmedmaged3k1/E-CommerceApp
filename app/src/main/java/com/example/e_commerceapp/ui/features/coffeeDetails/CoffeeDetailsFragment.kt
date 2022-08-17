package com.example.e_commerceapp.ui.features.coffeeDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Person.fromBundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentCoffeeDetailsBinding


class CoffeeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentCoffeeDetailsBinding
    private val args by navArgs<CoffeeDetailsFragmentArgs>()

    private val viewModel: CoffeeDetailsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoffeeDetailsBinding.inflate(inflater, container, false)

        binding.coffee = viewModel
        viewModel.coffeeItem=args.coffee
        binding.lifecycleOwner = this
        backButton(binding.root)
        return binding.root
    }
    private fun backButton(view: View){
        binding.backButton.setOnClickListener(View.OnClickListener {
            view.findNavController()
                .navigate(R.id.action_coffeeDetailsFragment_to_navigationFragment)
        })

    }
}