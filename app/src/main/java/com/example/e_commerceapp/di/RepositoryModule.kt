package com.example.e_commerceapp.di

import com.example.e_commerceapp.data.dataSource.remoteDataSource.CoffeeRemoteRepositoryImp
import com.example.e_commerceapp.domain.repositories.CoffeeRemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyCoffeeRepository(
        myRepositoryImpl: CoffeeRemoteRepositoryImp
    ): CoffeeRemoteRepository

}