package com.example.e_commerceapp.domain.useCases

import com.example.e_commerceapp.domain.repositories.RemoteRepository
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.User

class UserLoginUseCase(private val remoteRepository: RemoteRepository) {
    suspend fun loginUser(user: User): User? {
        return remoteRepository.login(user)
    }
}