package com.example.e_commerceapp.features.coffeeProducts

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.e_commerceapp.databinding.FragmentCoffeeProductBinding
import com.example.e_commerceapp.entities.Coffee

class CoffeeProductFragment : Fragment() {
    private lateinit var binding: FragmentCoffeeProductBinding
    private val coffeeRecyclerViewAdapter = CoffeeRecyclerViewAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoffeeProductBinding.inflate(inflater, container, false)

        initializeRecyclerView()
        return binding.root
    }

    private fun initializeRecyclerView() {
        val espresso = Coffee(
            10, "Black coffee", 20.5, "https://i.picsum.photos/id/26/200/200.jpg?hmac=A1fbIskzMWVQs1JuyIsJXYGuCgqVwevLXT4YaIJM3Rk", 1, 2,
            "Best black coffee", false, "coffee", 2, "000000"
        )
        val latte = Coffee(
            10, "latte coffee", 20.5, "https://i.picsum.photos/id/26/200/200.jpg?hmac=A1fbIskzMWVQs1JuyIsJXYGuCgqVwevLXT4YaIJM3Rk", 1, 2,
            "Best black coffee", false, "coffee", 2, "000000"
        )

        coffeeRecyclerViewAdapter.submitList(listOf(espresso,latte))
        binding.coffeeRecyclerViewer.adapter = coffeeRecyclerViewAdapter
        Log.d(TAG, "initializeRecyclerView: ${coffeeRecyclerViewAdapter.currentList.size} ")

    }


}