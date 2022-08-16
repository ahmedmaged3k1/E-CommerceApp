package com.example.e_commerceapp.features.coffeeProducts

import androidx.lifecycle.ViewModel
import com.example.e_commerceapp.domain.useCases.CoffeeProductsUseCase
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoffeeProductsViewModel @Inject constructor(coffeeUseCase: Lazy<CoffeeProductsUseCase>) : ViewModel() {


}