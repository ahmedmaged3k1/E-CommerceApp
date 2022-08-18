package com.example.e_commerceapp.data.dataSource.localDataSource.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CoffeeCart(
    @PrimaryKey(autoGenerate = true)
    var itemId: Int = 1,
    var id: Int? = null,
    var productName: String? = null,
    var userName: String,
    var price: Float? = null,
    var description: String? = null,
    var image: String? = null,
    var sugar: Float? = null,
    var size: String? = null
)
