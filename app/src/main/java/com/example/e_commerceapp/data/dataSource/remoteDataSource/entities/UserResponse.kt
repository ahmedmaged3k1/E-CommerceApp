package com.example.e_commerceapp.data.dataSource.remoteDataSource.entities

import com.google.gson.annotations.SerializedName

data  class UserResponse (
    @SerializedName("message" ) var message : String? = null)