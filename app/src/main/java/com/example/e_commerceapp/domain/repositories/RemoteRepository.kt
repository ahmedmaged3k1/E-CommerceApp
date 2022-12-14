package com.example.e_commerceapp.domain.repositories

import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.Coffee
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.User

interface RemoteRepository {
    suspend fun getAllCoffeeProduct(authToken : String): List<Coffee>
    suspend fun registerNewUser(user: User): Boolean
    suspend fun login(user: User): User?
    suspend fun updateProfile(): Boolean

}