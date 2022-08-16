package com.example.e_commerceapp.data.dataSource.remoteDataSource

import com.example.e_commerceapp.domain.repositories.CoffeeRemoteRepository
import com.example.e_commerceapp.entities.Coffee
import com.example.e_commerceapp.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CoffeeRemoteRepositoryImp @Inject constructor(private val coffeeApiService: CoffeeApiService) :
    CoffeeRemoteRepository {
    private lateinit var coffEeList: List<Coffee>
    override suspend fun getAllCoffeeProduct(authToken: String): List<Coffee> {
        withContext(Dispatchers.Default) {
            try {
                val response = coffeeApiService.getAllCoffeeProduct(authToken).body() ?: listOf()

                coffEeList = response

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
        return coffEeList
    }

    override suspend fun registerNewUser(user: User): Boolean {
        try {

            val response = coffeeApiService.registerNewUser(user).code() ?: false
            if (response == 200)
                return true

        } catch (e: Exception) {

            e.printStackTrace()
        }
        return false
    }

    override suspend fun login(user: User): User? {
        try {

            val responseCode = coffeeApiService.login(user).code()
            val response = coffeeApiService.login(user).body()

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







