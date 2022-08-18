package com.example.e_commerceapp.ui.features.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.Coffee
import com.example.e_commerceapp.databinding.FragmentCartBinding
import com.example.e_commerceapp.ui.features.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    private val viewModel: CartViewModel by viewModels()
    private val sharedViewModel: LoginViewModel by activityViewModels()


    private val coffeeRecyclerViewAdapter = CoffeeCartRecyclerViewAdapter()
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
        viewModel.getAllCartCoffees(sharedViewModel.confirmedUser.userName.toString())
        viewModel.coffeeList.observe(viewLifecycleOwner, Observer {
            coffeeRecyclerViewAdapter.submitList(viewModel.coffeeList.value)
            binding.coffeeRecyclerViewer.adapter = coffeeRecyclerViewAdapter
        })


    }

}