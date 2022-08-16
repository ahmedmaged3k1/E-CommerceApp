package com.example.e_commerceapp.features.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({


            view?.findNavController()?.navigate(R.id.action_splashFragment_to_onBoardingFragment)
        }, 4500)
        return binding.root
    }

}