package com.example.e_commerceapp.data.dataSource.localDataSource.room.cartDatabase

import androidx.room.*
import com.example.e_commerceapp.data.dataSource.localDataSource.entities.CoffeeCart


@Dao
interface CoffeeCartDao {
    @Insert
    suspend fun insert(coffee: CoffeeCart)



    @Update
    suspend fun update(coffee: CoffeeCart)

    @Delete
    suspend fun delete(coffee: CoffeeCart)


    @Query("SELECT * FROM  CoffeeCart where userName =  :name  ")
    suspend fun getCartCoffee(name: String): List<CoffeeCart>?


}