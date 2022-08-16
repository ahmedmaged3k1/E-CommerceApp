package com.example.e_commerceapp.features.login

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.domain.useCases.UserLoginUseCase
import com.example.e_commerceapp.entities.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: UserLoginUseCase) : ViewModel() {

    var userEmail = MutableLiveData<String>()
    var userPassword = MutableLiveData<String>()
     var confirmedUser = User()
    var observer = MutableLiveData<Int>(1)
    fun login() {
        Log.d(TAG, "login:entered  ")
        viewModelScope.launch {
            if (userEmail.value?.isEmpty() == true || userPassword.value?.isEmpty() == true) {
                return@launch
            } else {
                val user = User("", userEmail.value, userPassword.value)

                if (loginUseCase.loginUser(user)?.token !=null) {
                    observer.value = observer.value?.inc()
                    observer.value = observer.value?.dec()
                    confirmedUser = loginUseCase.loginUser(user)!!
                }


            }

        }

    }
}