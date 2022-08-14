package com.example.e_commerceapp.features.navigationHome

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.R
import com.example.e_commerceapp.entities.Coffee

@BindingAdapter("coffeeImage")
fun ImageView.setCoffeeImage(item: Coffee?, view:ImageView) {
    if (item != null) {
        Glide.with(view.context)
            .load(item.image)
            .into(view)
    }
}