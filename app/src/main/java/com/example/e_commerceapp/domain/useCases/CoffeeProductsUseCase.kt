package com.example.e_commerceapp.domain.useCases

import com.example.e_commerceapp.domain.repositories.RemoteRepository
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.Coffee

class CoffeeProductsUseCase(private val remoteRepository: RemoteRepository) {
    suspend fun getAllProducts(authToken: String):List<Coffee>{

        return remoteRepository.getAllCoffeeProduct(authToken)
    }
}