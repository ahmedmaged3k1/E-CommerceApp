package com.example.e_commerceapp.features.navigationHome

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.e_commerceapp.features.cart.CartFragment
import com.example.e_commerceapp.features.coffeeProducts.CoffeeProductFragment
import com.example.e_commerceapp.features.profile.ProfileFragment

class PageAdapter(fragment: NavigationFragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CoffeeProductFragment()
            1 -> ProfileFragment()
            2 -> CartFragment()
            else -> throw  Resources.NotFoundException("Position not found")


        }
    }
}