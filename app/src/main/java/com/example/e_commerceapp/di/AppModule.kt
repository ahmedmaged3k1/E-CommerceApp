package com.example.e_commerceapp.di

import android.app.Application
import com.example.e_commerceapp.data.dataSource.localDataSource.room.CoffeeCartDao
import com.example.e_commerceapp.data.dataSource.localDataSource.room.CoffeeDatabase
import com.example.e_commerceapp.data.dataSource.remoteDataSource.ApiService
import com.example.e_commerceapp.data.network.Credentials
import com.example.e_commerceapp.domain.repositories.LocalRepository
import com.example.e_commerceapp.domain.repositories.RemoteRepository
import com.example.e_commerceapp.domain.useCases.CartUseCase
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
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Credentials.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideMyCoffeeApi(retrofit: Retrofit): ApiService {

        val api by lazy {
            retrofit.create(ApiService::class.java)
        }
        return api
    }


    @Provides
    @Singleton
    fun provideMyCoffeeCartUseCase(localRepository: LocalRepository): CartUseCase {
        return CartUseCase(localRepository)
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

    @Provides
    @Singleton
    fun provideRoomDb(context: Application): CoffeeDatabase {
        return CoffeeDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideRoomDao(coffeeDatabase: CoffeeDatabase): CoffeeCartDao {
        return coffeeDatabase.coffeeDao
    }

}


