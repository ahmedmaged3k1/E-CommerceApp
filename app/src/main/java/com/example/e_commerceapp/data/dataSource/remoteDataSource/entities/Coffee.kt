package com.example.e_commerceapp.data.dataSource.remoteDataSource.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coffee(
    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("productName" ) var productName : String? = null,
    @SerializedName("price"       ) var price       : Float?    = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("image"       ) var image       : String? = null,
    @SerializedName("sugar"       ) var sugar       : Float?    = null,
    @SerializedName("size"        ) var size        : String? = null) : Parcelable
