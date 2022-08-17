package com.example.e_commerceapp.data.dataSource.localDataSource

import com.example.e_commerceapp.data.dataSource.localDataSource.entities.CoffeeCart
import com.example.e_commerceapp.data.dataSource.localDataSource.room.CoffeeCartDao
import com.example.e_commerceapp.domain.repositories.LocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalRepositoryIml @Inject constructor(private val coffeeDao: CoffeeCartDao) :
    LocalRepository {

    override suspend fun insert(coffee: CoffeeCart) {
        withContext(Dispatchers.IO) {
            coffeeDao.insert(coffee)
        }
    }

    override suspend fun update(coffee: CoffeeCart) {
        withContext(Dispatchers.IO) {
            coffeeDao.update(coffee)
        }
    }

    override suspend fun delete(coffee: CoffeeCart) {
        withContext(Dispatchers.IO) {
            coffeeDao.delete(coffee)
        }
    }

    override suspend fun getCartCoffee(name: String): List<CoffeeCart>? {
        return coffeeDao.getCartCoffee(name)

    }

}