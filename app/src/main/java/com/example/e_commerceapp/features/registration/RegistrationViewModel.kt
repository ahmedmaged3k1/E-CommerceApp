package com.example.e_commerceapp.features.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.domain.useCases.UserRegistrationUseCase
import com.example.e_commerceapp.entities.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val userRegistrationUseCase: UserRegistrationUseCase) :
    ViewModel() {

    var userName = MutableLiveData<String>()
    var userEmail = MutableLiveData<String>()
    var userPassword = MutableLiveData<String>()
    var observer = MutableLiveData<Int>(1)
    fun register() {
        viewModelScope.launch {
            if (userName.value?.isEmpty() == true || userEmail.value?.isEmpty() == true || userPassword.value?.isEmpty() == true) {
                return@launch
            } else {
                val newUser = User(userName.value, userEmail.value, userPassword.value)
                if (userRegistrationUseCase.registerUser(newUser))
                {
                    observer.value= observer.value?.inc()
                    observer.value=observer.value?.dec()

                }
            }


        }

    }
}