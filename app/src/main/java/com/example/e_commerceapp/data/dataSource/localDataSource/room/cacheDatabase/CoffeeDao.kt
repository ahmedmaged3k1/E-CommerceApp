package com.example.e_commerceapp.data.dataSource.localDataSource.room.cacheDatabase

import androidx.room.*
import com.example.e_commerceapp.data.dataSource.localDataSource.entities.CoffeeCart
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.Coffee


@Dao
interface CoffeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(coffees: List<Coffee>)


    @Query("SELECT * FROM  Coffee   ")
    suspend fun getAllCoffee(): List<Coffee>?


}