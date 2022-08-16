package com.example.e_commerceapp.features.coffeeProducts

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.domain.useCases.CoffeeProductsUseCase
import com.example.e_commerceapp.entities.Coffee
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeProductsViewModel @Inject constructor(private val coffeeUseCase: CoffeeProductsUseCase) : ViewModel() {
     val coffeeList = MutableLiveData<List<Coffee>>()

     fun getAllCoffees(authToken: String) {
         viewModelScope.launch {

             coffeeList.postValue(coffeeUseCase.getAllProducts(authToken))
             Log.d(TAG, "getAllCoffees size : ${coffeeUseCase.getAllProducts(authToken).size}")
         }

    }
}