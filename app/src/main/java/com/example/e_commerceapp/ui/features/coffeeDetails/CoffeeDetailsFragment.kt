package com.example.e_commerceapp.ui.features.coffeeDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.e_commerceapp.databinding.FragmentCoffeeDetailsBinding


class CoffeeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentCoffeeDetailsBinding

    private val viewModel: CoffeeDetailsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoffeeDetailsBinding.inflate(inflater, container, false)
        binding.coffee = viewModel

        binding.lifecycleOwner = this
        return binding.root
    }
}