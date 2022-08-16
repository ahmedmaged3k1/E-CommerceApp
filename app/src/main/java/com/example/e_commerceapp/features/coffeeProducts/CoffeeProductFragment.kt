package com.example.e_commerceapp.features.coffeeProducts

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.e_commerceapp.databinding.FragmentCoffeeProductBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CoffeeProductFragment : Fragment() {
    private lateinit var binding: FragmentCoffeeProductBinding
    private val coffeeRecyclerViewAdapter = CoffeeRecyclerViewAdapter()
    private val viewModel: CoffeeProductsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoffeeProductBinding.inflate(inflater, container, false)
        initializeRecyclerView()


        return binding.root
    }


    private fun initializeRecyclerView() {

        val token =
            "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhaG1lZEBnbWFpbC5jb20iLCJpYXQiOjE2NjA2Njc0MTMsImV4cCI6MTY2MDc2MzgxM30.RCOlsHxcgA4n8ivJRMvVTDmehV6VdbaTjSURz4vLJXOUwg0uNVTQBd-1j6xXa-mxXTAeP005rBTuXEIh036NIQ"
        viewModel.getAllCoffees("Bearer $token")
        viewModel.coffeeList.observe(viewLifecycleOwner, Observer {
            coffeeRecyclerViewAdapter.submitList(viewModel.coffeeList.value)
        })

        binding.coffeeRecyclerViewer.adapter = coffeeRecyclerViewAdapter


    }


}
/*
  val espresso = Coffee(
            10,
            "espresso  coffee",
            20,
            "Best black  espresso coffee",
            "https://i.picsum.photos/id/26/200/200.jpg?hmac=A1fbIskzMWVQs1JuyIsJXYGuCgqVwevLXT4YaIJM3Rk",
            1,
            "2"
        )
        val latte = Coffee(
            10,
            "latte coffee",
            20,
            "Best black coffee",
            "https://i.picsum.photos/id/26/200/200.jpg?hmac=A1fbIskzMWVQs1JuyIsJXYGuCgqVwevLXT4YaIJM3Rk",
            1,
            "2"
        )
 */