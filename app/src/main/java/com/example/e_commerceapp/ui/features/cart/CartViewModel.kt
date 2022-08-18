package com.example.e_commerceapp.ui.features.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.data.dataSource.localDataSource.entities.CoffeeCart
import com.example.e_commerceapp.domain.useCases.CartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val cartUseCase: CartUseCase): ViewModel() {
    val coffeeList = MutableLiveData<List<CoffeeCart>>()


    fun getAllCartCoffees(name:String) {
        viewModelScope.launch {

            coffeeList.postValue(cartUseCase.getCartCoffee(name))
        }

    }
}