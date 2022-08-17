package com.example.e_commerceapp.domain.repositories

import com.example.e_commerceapp.data.dataSource.localDataSource.entities.CoffeeCart

interface LocalRepository {

    suspend fun insert(coffee: CoffeeCart)


    suspend fun update(coffee: CoffeeCart)


    suspend fun delete(coffee: CoffeeCart)


    suspend fun getCartCoffee(name: String): List<CoffeeCart>?
}