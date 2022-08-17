package com.example.e_commerceapp.ui.features.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.e_commerceapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileFragmentViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.user = viewModel
        binding.lifecycleOwner = this
        updateOnClick()
        return binding.root

    }

    private fun updateOnClick() {
        binding.confirmButtonProfile.setOnClickListener {
            if (validateUpdate()) {
                Toast.makeText(activity, "Updated SSuccessfully", Toast.LENGTH_SHORT).show()
            }
        }


    }


    private fun validateUpdate(): Boolean {
        if (binding.updateName.text.isEmpty() || binding.updateEmail.text.isEmpty() || binding.updatePassword.text.isEmpty()) {
            val text = "Please Complete All Fields"
            val duration = Toast.LENGTH_SHORT
            val applicationContext = activity
            Toast.makeText(applicationContext, text, duration).show()
            return false
        }
        updateProfile()
        return true
    }

    private fun updateProfile() {

    }
}
