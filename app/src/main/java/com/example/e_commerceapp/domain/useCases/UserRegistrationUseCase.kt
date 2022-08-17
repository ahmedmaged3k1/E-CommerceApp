package com.example.e_commerceapp.domain.useCases

import com.example.e_commerceapp.domain.repositories.RemoteRepository
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.User

class UserRegistrationUseCase(private val remoteRepository: RemoteRepository) {
    suspend fun registerUser(user: User): Boolean {

        return remoteRepository.registerNewUser(user)
    }
}