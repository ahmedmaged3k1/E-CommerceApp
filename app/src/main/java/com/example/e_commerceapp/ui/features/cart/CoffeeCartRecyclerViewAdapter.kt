package com.example.e_commerceapp.ui.features.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapp.data.dataSource.localDataSource.entities.CoffeeCart
import com.example.e_commerceapp.databinding.CartItemBinding

val diffCallback = object : DiffUtil.ItemCallback<CoffeeCart>() {
    override fun areItemsTheSame(oldItem: CoffeeCart, newItem: CoffeeCart): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CoffeeCart, newItem: CoffeeCart): Boolean {
        return oldItem.itemId == newItem.itemId


    }
}

@Suppress("DEPRECATION")
class CoffeeCartRecyclerViewAdapter :
    ListAdapter<CoffeeCart, CoffeeCartRecyclerViewAdapter.CoffeeViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.bind(getItem(position))


    }

    inner class CoffeeViewHolder constructor(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CoffeeCart?) {
            binding.coffee = item
            binding.executePendingBindings()

        }


    }

    fun from(parent: ViewGroup): CoffeeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CartItemBinding.inflate(inflater, parent, false)
        return CoffeeViewHolder(binding)
    }


}