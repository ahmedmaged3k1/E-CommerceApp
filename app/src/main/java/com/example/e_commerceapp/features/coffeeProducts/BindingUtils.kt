package com.example.e_commerceapp.features.coffeeProducts

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.e_commerceapp.entities.Coffee
import com.example.e_commerceapp.features.navigationHome.NavigationFragmentDirections


@BindingAdapter("coffeeImage")
fun ImageView.setCoffeeImage(item: Coffee?) {
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