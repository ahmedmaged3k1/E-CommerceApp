package com.example.e_commerceapp.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coffee(@SerializedName("id"                 ) var id               : Int,
                  @SerializedName("name"               ) var name             : String,
                  @SerializedName("price"              ) var price            : Double,
                  @SerializedName("image"              ) var image            : String,
                  @SerializedName("size"               ) var size             : Int,
                  @SerializedName("sugar"              ) var sugar            : Int,
                  @SerializedName("description"        ) var description      : String,
                  @SerializedName("is_added_to_cart"   ) var isAddedToCart    : Boolean,
                  @SerializedName("category"           ) var category         : String,
                  @SerializedName("bought_items_count" ) var boughtItemsCount : Int,
                  @SerializedName("color"              ) var color            : String) : Parcelable
