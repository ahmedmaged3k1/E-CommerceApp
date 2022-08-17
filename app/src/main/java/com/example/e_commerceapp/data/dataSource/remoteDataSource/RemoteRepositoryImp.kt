package com.example.e_commerceapp.data.dataSource.remoteDataSource

import com.example.e_commerceapp.domain.repositories.RemoteRepository
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.Coffee
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteRepositoryImp @Inject constructor(private val apiService: ApiService) :
    RemoteRepository {
    private lateinit var coffEeList: List<Coffee>
    override suspend fun getAllCoffeeProduct(authToken: String): List<Coffee> {
        withContext(Dispatchers.Default) {
            try {
                val response = apiService.getAllCoffeeProduct(authToken).body() ?: listOf()

                coffEeList = response

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
        return coffEeList
    }

    override suspend fun registerNewUser(user: User): Boolean {
        try {

            val response = apiService.registerNewUser(user).code() ?: false
            if (response == 200)
                return true

        } catch (e: Exception) {

            e.printStackTrace()
        }
        return false
    }

    override suspend fun login(user: User): User? {
        try {

            val responseCode = apiService.login(user).code()
            val response = apiService.login(user).body()

            if (responseCode == 200)
                return response

        } catch (e: Exception) {

            e.printStackTrace()
        }
        return null
    }

    override suspend fun updateProfile(): Boolean {
        TODO("Not yet implemented")
    }

}







