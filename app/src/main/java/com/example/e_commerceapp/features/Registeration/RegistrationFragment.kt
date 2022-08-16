package com.example.e_commerceapp.features.Registeration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentLoginBinding
import com.example.e_commerceapp.databinding.FragmentRegisterationBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegisterationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterationBinding.inflate(inflater, container, false)
       // buttonOnClick()
        return binding.root
    }
 /*   private fun buttonOnClick() {
        binding.getStartedButton.setOnClickListener {
            navigate(it)
        }

    }*/

    private fun navigate(view: View) {

        view.findNavController().navigate(R.id.action_loginFragment_to_navigationFragment)
    }

}