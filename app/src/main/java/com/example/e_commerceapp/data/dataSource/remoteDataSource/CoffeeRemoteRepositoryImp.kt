package com.example.e_commerceapp.data.dataSource.remoteDataSource

import com.example.e_commerceapp.domain.repositories.CoffeeRemoteRepository
import com.example.e_commerceapp.entities.Coffee
import com.example.e_commerceapp.entities.User
import javax.inject.Inject

class CoffeeRemoteRepositoryImp @Inject constructor(private val coffeeApiService: CoffeeApiService) :
    CoffeeRemoteRepository {

    override suspend fun getAllCoffeeProduct(): List<Coffee> {
        TODO("Not yet implemented")
    }

    override suspend fun registerNewUser(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun login(): User {
        TODO("Not yet implemented")
    }

    override suspend fun updateProfile(): Boolean {
        TODO("Not yet implemented")
    }

}