package com.example.e_commerceapp.domain.useCases

import com.example.e_commerceapp.domain.repositories.CoffeeRemoteRepository
import com.example.e_commerceapp.entities.Coffee

class CoffeeProductsUseCase(private val coffeeRemoteRepository: CoffeeRemoteRepository) {
    suspend fun getAllProducts(authToken: String):List<Coffee>{

        return coffeeRemoteRepository.getAllCoffeeProduct(authToken)
    }
}