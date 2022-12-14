package com.example.e_commerceapp.ui.features.coffeeProducts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.e_commerceapp.data.dataSource.localDataSource.sharedPrefrence.SharedPreference
import com.example.e_commerceapp.databinding.FragmentCoffeeProductBinding
import com.example.e_commerceapp.ui.features.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CoffeeProductFragment : Fragment() {
    private lateinit var binding: FragmentCoffeeProductBinding
    private val coffeeRecyclerViewAdapter = CoffeeRecyclerViewAdapter()
    private val viewModel: CoffeeProductsViewModel by viewModels()
    private val sharedViewModel: LoginViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        SharedPreference.init(requireContext())
        binding = FragmentCoffeeProductBinding.inflate(inflater, container, false)
        initializeRecyclerView()


        return binding.root
    }


    private fun initializeRecyclerView() {

        viewModel.getAllCoffees(
            "Bearer ${
                SharedPreference.readStringFromSharedPreference("token", "").toString()
            }"
        )
        viewModel.coffeeList.observe(viewLifecycleOwner) {
            coffeeRecyclerViewAdapter.submitList(viewModel.coffeeList.value)
            binding.coffeeRecyclerViewer.adapter = coffeeRecyclerViewAdapter
        }


    }


}