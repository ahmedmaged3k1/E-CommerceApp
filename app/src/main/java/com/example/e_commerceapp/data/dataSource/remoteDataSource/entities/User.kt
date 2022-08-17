package com.example.e_commerceapp.data.dataSource.remoteDataSource.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @SerializedName("userName" ) var userName : String? = null,
    @SerializedName("email"    ) var email    : String? = null,
    var password : String? = null,
    @SerializedName("token"    ) var token    : String? = null
) : Parcelable
