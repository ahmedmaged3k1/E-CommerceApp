package com.example.e_commerceapp.data.dataSource.remoteDataSource

import com.example.e_commerceapp.entities.Coffee
import com.example.e_commerceapp.entities.User
import retrofit2.Response
import retrofit2.http.*

interface CoffeeApiService {
    @GET("")
    suspend fun getAllCoffeeProduct(@Query("apiKey") key: String): Response<Coffee>

    @POST("")
    suspend fun registerNewUser(@Body params: User,@Query("apiKey") key: String): Response<User>

    @POST("")
    suspend fun login(@Body params: User,@Query("apiKey") key: String): Response<User>

    @PUT("")
    suspend fun updateProfile(@Body params: User,@Query("apiKey") key: String): Response<User>
}