package com.example.e_commerceapp.features.coffeeProducts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.domain.useCases.CoffeeProductsUseCase
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.Coffee
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeProductsViewModel @Inject constructor(private val coffeeUseCase: CoffeeProductsUseCase) : ViewModel() {
     val coffeeList = MutableLiveData<ArrayList<Coffee>>()

     fun getAllCoffees(authToken: String) {
         viewModelScope.launch {
             coffeeList.postValue(coffeeUseCase.getAllProducts(authToken) as ArrayList<Coffee>?)
         }

    }
}