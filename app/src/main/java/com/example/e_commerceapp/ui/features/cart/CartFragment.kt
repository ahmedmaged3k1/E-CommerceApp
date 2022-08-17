package com.example.e_commerceapp.ui.features.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.Coffee
import com.example.e_commerceapp.databinding.FragmentCartBinding
import com.example.e_commerceapp.ui.features.coffeeDetails.CoffeeDetailsViewModel
import com.example.e_commerceapp.ui.features.coffeeProducts.CoffeeRecyclerViewAdapter


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private val sharedViewModel: CoffeeDetailsViewModel by activityViewModels()
    private val viewModel: CartViewModel by viewModels()
    private val args by navArgs<CartFragmentArgs>()

    private val coffeeRecyclerViewAdapter = CoffeeRecyclerViewAdapter()
    val list = mutableListOf<Coffee>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        initializeRecyclerView()
        return binding.root
    }

    private fun initializeRecyclerView() {

        list.add(args.item)
        coffeeRecyclerViewAdapter.submitList(list)
        binding.coffeeRecyclerViewer.adapter = coffeeRecyclerViewAdapter


    }
}