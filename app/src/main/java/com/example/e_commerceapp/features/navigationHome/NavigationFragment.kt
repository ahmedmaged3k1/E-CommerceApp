package com.example.e_commerceapp.features.navigationHome


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.e_commerceapp.databinding.FragmentNavigationBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class NavigationFragment : Fragment() {

    private lateinit var binding: FragmentNavigationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNavigationBinding.inflate(inflater, container, false)
        homeScreenNavigationSetup()
        return binding.root
    }

    private fun homeScreenNavigationSetup() {
        viewPagerInitialization()
        tabLayoutInitialization()
    }

    private fun tabLayoutInitialization() {

        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.homeViewPager.currentItem = tab.position;
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    private fun viewPagerInitialization() {
        binding.homeViewPager.adapter = PageAdapter(this)
        binding.homeViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })
    }

}



