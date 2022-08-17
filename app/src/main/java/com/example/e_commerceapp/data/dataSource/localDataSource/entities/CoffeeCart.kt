package com.example.e_commerceapp.data.dataSource.localDataSource.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CoffeeCart(
    var id: Int? = null,
    var productName: String? = null,
    @PrimaryKey
    var userName: String,
    var price: Float? = null,
    var description: String? = null,
    var image: String? = null,
    var sugar: Float? = null,
    var size: String? = null
)
