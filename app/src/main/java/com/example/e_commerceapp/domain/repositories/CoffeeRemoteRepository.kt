package com.example.e_commerceapp.domain.repositories

import com.example.e_commerceapp.entities.Coffee
import com.example.e_commerceapp.entities.User

interface CoffeeRemoteRepository {
    suspend fun getAllCoffeeProduct(authToken : String): List<Coffee>
    suspend fun registerNewUser(user: User): Boolean
    suspend fun login(user: User): User?
    suspend fun updateProfile(): Boolean

}