package com.example.e_commerceapp.data.dataSource.remoteDataSource

import com.example.e_commerceapp.entities.Coffee
import com.example.e_commerceapp.entities.User
import com.example.e_commerceapp.entities.UserResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface CoffeeApiService {
    @GET("/product/all")
    suspend fun getAllCoffeeProduct(@Header("Authorization" )authToken : String): Response<List<Coffee>>

    @POST("api/auth/signup")
    suspend fun registerNewUser(@Body params: User): Response<UserResponse>

    @POST("/api/auth/signin")
    suspend fun login(@Body params: User): Response<User>

    @PUT("")
    suspend fun updateProfile(@Body params: User): Response<User>
}