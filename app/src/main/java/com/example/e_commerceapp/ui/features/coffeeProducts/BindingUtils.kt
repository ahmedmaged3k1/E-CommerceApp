package com.example.e_commerceapp.ui.features.coffeeProducts

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.e_commerceapp.data.dataSource.localDataSource.entities.CoffeeCart
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.Coffee


@BindingAdapter("coffeeImage")
fun ImageView.setCoffeeImage(item: Coffee?) {
    item?.let {
        Glide.with(context)
            .load(item.image)
            .into(this)
    }
}
@BindingAdapter("coffeeImageCart")
fun ImageView.setCoffeeImageCart(item: CoffeeCart?) {
    item?.let {
        Glide.with(context)
            .load(item.image)
            .into(this)
    }
}
@BindingAdapter("coffeeDetails")
fun ImageView.navigateCoffeeItem(item: Coffee?) {
    item?.let {

    }
}