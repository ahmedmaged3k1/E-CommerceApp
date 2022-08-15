package com.example.e_commerceapp.di

import com.example.e_commerceapp.data.dataSource.remoteDataSource.CoffeeApiService
import com.example.e_commerceapp.data.dataSource.remoteDataSource.CoffeeRemoteRepositoryImp
import com.example.e_commerceapp.data.network.Credentials
import com.example.e_commerceapp.domain.useCases.CoffeeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMyCoffeeApi(): CoffeeApiService {
        return Retrofit.Builder().baseUrl(Credentials.baseUrl).build().create()
    }


    @Provides
    @Singleton
    fun provideMyCoffeeUseCase(coffeeRemoteRepositoryImp: CoffeeRemoteRepositoryImp): CoffeeUseCase {
        return CoffeeUseCase(coffeeRemoteRepositoryImp)
    }

}