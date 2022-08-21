package com.example.e_commerceapp.domain.useCases

import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.Coffee
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.CoffeeContainer
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.asDomainModel
import com.example.e_commerceapp.domain.repositories.LocalRepository
import com.example.e_commerceapp.domain.repositories.RemoteRepository

class CoffeeProductsUseCase(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) {
    suspend fun getAllProducts(authToken: String): List<Coffee>? {

        localRepository.insertAllCacheCoffee(
            remoteRepository.getAllCoffeeProduct(authToken)
        )
        return remoteRepository.getAllCoffeeProduct(authToken)
    }
}