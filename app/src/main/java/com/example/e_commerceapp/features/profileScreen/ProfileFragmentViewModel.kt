package com.example.e_commerceapp.features.profileScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileFragmentViewModel : ViewModel() {

    var userName = MutableLiveData<String>()
    var userEmail = MutableLiveData<String>()
    var userPassword = MutableLiveData<String>()
}