package com.example.e_commerceapp.ui.features.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.User
import com.example.e_commerceapp.domain.useCases.UserRegistrationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val userRegistrationUseCase: UserRegistrationUseCase) :
    ViewModel() {

    var userName = MutableLiveData<String>()
    var userEmail = MutableLiveData<String>()
    var userPassword = MutableLiveData<String>()
    var observer = MutableLiveData(1)
    fun register() {
        viewModelScope.launch {
            if (userName.value?.isEmpty() == true || userEmail.value?.isEmpty() == true || userPassword.value?.isEmpty() == true ||
                userEmail.value?.contains("@") == false ||
                userEmail.value?.contains(".com") == false
            ) {
                return@launch
            } else {
                val newUser = User(userName.value, userEmail.value, userPassword.value)
                if (userRegistrationUseCase.registerUser(newUser)) {
                    observer.value = observer.value?.inc()
                    observer.value = observer.value?.dec()

                }
            }


        }

    }
}