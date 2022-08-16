package com.example.e_commerceapp.data.network

import com.example.e_commerceapp.data.dataSource.remoteDataSource.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {


    companion object {
        private val retrofit by lazy {
            val okHttpClient = OkHttpClient.Builder().addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).build()
            Retrofit.Builder().baseUrl(Credentials.baseUrl).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }

        private val api by lazy {
            retrofit.create(ApiService::class.java)
        }

        fun getCoffeeApi(): ApiService {
            return api
        }
    }


}
/*companion object {
        private val retrofitBuilder =
            Retrofit.Builder().baseUrl(Credentials.baseUrl)
                . addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
        private val retrofit: Retrofit = retrofitBuilder.build()
        private val newsApi: NewsApiService = retrofit.create(NewsApiService::class.java)
        fun getNewsApi(): NewsApiService {
            return newsApi
        }
    }

 */