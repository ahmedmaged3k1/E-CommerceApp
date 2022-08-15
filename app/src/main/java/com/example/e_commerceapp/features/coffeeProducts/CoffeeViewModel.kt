package com.example.e_commerceapp.features.coffeeProducts

import androidx.lifecycle.ViewModel
import com.example.e_commerceapp.domain.useCases.CoffeeUseCase
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class CoffeeViewModel @Inject constructor(coffeeUseCase: Lazy<CoffeeUseCase>) : ViewModel() {


}