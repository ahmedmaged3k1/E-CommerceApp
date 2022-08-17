package com.example.e_commerceapp.domain.useCases

import com.example.e_commerceapp.data.dataSource.localDataSource.entities.CoffeeCart
import com.example.e_commerceapp.domain.repositories.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel


class CartUseCase(private val localRepository: LocalRepository) {
    suspend fun getCartCoffee(name: String): List<CoffeeCart> {

        return localRepository.getCartCoffee(name)!!
    }

    suspend fun addItem(coffeeCart: CoffeeCart) {
        localRepository.insert(coffeeCart)
    }
}