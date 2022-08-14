package com.example.e_commerceapp.features.navigationHome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapp.databinding.CoffeItemBinding
import com.example.e_commerceapp.entities.Coffee

val diffCallback = object : DiffUtil.ItemCallback<Coffee>() {
    override fun areItemsTheSame(oldItem: Coffee, newItem: Coffee): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Coffee, newItem: Coffee): Boolean {
        return oldItem.id == newItem.id


    }
}

class CoffeeRecyclerViewAdapter :
    ListAdapter<Coffee, CoffeeRecyclerViewAdapter.CoffeeViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CoffeeViewHolder constructor(private val binding: CoffeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Coffee) {
            binding.coffee = item
            binding.executePendingBindings()
        }


    }

    fun from(parent: ViewGroup): CoffeeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CoffeItemBinding.inflate(inflater, parent, false)
        return CoffeeViewHolder(binding)
    }


}