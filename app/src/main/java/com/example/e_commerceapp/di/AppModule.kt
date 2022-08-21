package com.example.e_commerceapp.di

import android.app.Application
import com.example.e_commerceapp.data.dataSource.localDataSource.room.cacheDatabase.CoffeeDao
import com.example.e_commerceapp.data.dataSource.localDataSource.room.cacheDatabase.CoffeeOfflineDatabase
import com.example.e_commerceapp.data.dataSource.localDataSource.room.cartDatabase.CoffeeCartDao
import com.example.e_commerceapp.data.dataSource.localDataSource.room.cartDatabase.CoffeeDatabase
import com.example.e_commerceapp.data.dataSource.localDataSource.sharedPrefrence.SharedPreference
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
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideMyCoffeeCartUseCase(localRepository: LocalRepository): CartUseCase {
        return CartUseCase(localRepository)
    }

    @Provides
    @Singleton
    fun provideMyCoffeeUseCase(remoteRepository: RemoteRepository,localRepository: LocalRepository): CoffeeProductsUseCase {
        return CoffeeProductsUseCase(remoteRepository,localRepository)
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
    @Provides
    @Singleton
    fun provideRoomCacheDb(context: Application): CoffeeOfflineDatabase {
        return CoffeeOfflineDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideRoomCacheDao(coffeeCacheDatabase: CoffeeOfflineDatabase): CoffeeDao {
        return coffeeCacheDatabase.coffeeDao

    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    if (chain.request().url.toString().contains("get")) {
                        it.addHeader(
                            "Authorization",
                            "Bearer ${SharedPreference.readStringFromSharedPreference("token", "")}"
                        )
                    }
                }
                    .build())
            } .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .readTimeout(timeout = 120, TimeUnit.SECONDS).build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Credentials.baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())

            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    /*

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
   @Provides
    @Singleton
    fun provideSharedPref(app: Application): SharedPreferences {
        return app.getSharedPreferences(
            BuildConfig.PrefName,
            Context.MODE_PRIVATE
        )
    }
    @Provides
    @Singleton
    fun provideOkHttpClient(sharedPreferences: SharedPreferences): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor {
                val token = sharedPreferences.getString(SharedPrefKeys.TOKEN, "")
                val modifiedRequest = it.request().newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
                it.proceed(modifiedRequest)
            }
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .readTimeout(timeout = 120, TimeUnit.SECONDS)
            .build()
    }
     */

}


