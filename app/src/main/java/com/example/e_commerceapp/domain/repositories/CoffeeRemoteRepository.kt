package com.example.e_commerceapp.domain.repositories

import com.example.e_commerceapp.entities.Coffee
import com.example.e_commerceapp.entities.User

interface CoffeeRemoteRepository {
    suspend fun getAllCoffeeProduct(): List<Coffee>
    suspend fun registerNewUser(): Boolean
    suspend fun login(): User
    suspend fun updateProfile(): Boolean

}