package com.example.e_commerceapp.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.e_commerceapp.databinding.FragmentCoffeeDetailsBinding

class CoffeeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentCoffeeDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoffeeDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }
}