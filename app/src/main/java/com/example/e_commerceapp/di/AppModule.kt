package com.example.e_commerceapp.di

import com.example.e_commerceapp.data.dataSource.remoteDataSource.ApiService
import com.example.e_commerceapp.data.network.Credentials
import com.example.e_commerceapp.domain.repositories.RemoteRepository
import com.example.e_commerceapp.domain.useCases.CoffeeProductsUseCase
import com.example.e_commerceapp.domain.useCases.UserLoginUseCase
import com.example.e_commerceapp.domain.useCases.UserRegistrationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMyCoffeeApi(): ApiService {
        val retrofit by lazy {
            val okHttpClient = OkHttpClient.Builder().addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).build()
            Retrofit.Builder().baseUrl(Credentials.baseUrl).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        val api by lazy {
            retrofit.create(ApiService::class.java)
        }
        return api
    }


    @Provides
    @Singleton
    fun provideMyCoffeeUseCase(remoteRepository: RemoteRepository): CoffeeProductsUseCase {
        return CoffeeProductsUseCase(remoteRepository)
    }

    @Provides
    @Singleton
    fun provideUserRegistrationUseCase(remoteRepository: RemoteRepository): UserRegistrationUseCase {
        return UserRegistrationUseCase(remoteRepository)
    }
    @Provides
    @Singleton
    fun provideUserLoginUseCase(remoteRepository: RemoteRepository): UserLoginUseCase {
        return UserLoginUseCase(remoteRepository)
    }

}

/*
    @Provides
    @Singleton
    fun provideMyCoffeeApi(): CoffeeApiService {
        val retrofit by lazy {
            val okHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    it.addHeader(
                        "Authorization",
                        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhaG1lZEBnbWFpbC5jb20iLCJpYXQiOjE2NjA2Njc0MTMsImV4cCI6MTY2MDc2MzgxM30.RCOlsHxcgA4n8ivJRMvVTDmehV6VdbaTjSURz4vLJXOUwg0uNVTQBd-1j6xXa-mxXTAeP005rBTuXEIh036NIQ"
                    )

                }.build()).also {

                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY

                    }

                }

            }.build()
            Retrofit.Builder().baseUrl(Credentials.baseUrl).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build()

        }


        val api by lazy {
            retrofit.create(CoffeeApiService::class.java)
        }
        return api
    }

 */
