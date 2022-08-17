package com.example.e_commerceapp.data.dataSource.localDataSource

import android.app.Application
import com.example.e_commerceapp.data.dataSource.localDataSource.entities.CoffeeCart
import com.example.e_commerceapp.data.dataSource.localDataSource.room.CoffeeDatabase
import com.example.e_commerceapp.domain.repositories.LocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalRepositoryIml(private val app: Application) : LocalRepository {
    private var coffeeDatabase: CoffeeDatabase? = CoffeeDatabase.getInstance(app.applicationContext)
    override suspend fun insert(coffee: CoffeeCart) {
        withContext(Dispatchers.IO) {
            coffeeDatabase?.coffeeDao?.insert(coffee)
        }
    }

    override suspend fun update(coffee: CoffeeCart) {
        withContext(Dispatchers.IO) {
            coffeeDatabase?.coffeeDao?.update(coffee)
        }
    }

    override suspend fun delete(coffee: CoffeeCart) {
        withContext(Dispatchers.IO) {
            coffeeDatabase?.coffeeDao?.delete(coffee)
        }
    }

    override suspend fun getCartCoffee(name: String): List<CoffeeCart>? {
        return coffeeDatabase?.coffeeDao?.getCartCoffee(name)

    }

}