package com.example.e_commerceapp.ui.features.login

import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.data.dataSource.localDataSource.sharedPrefrence.SharedPreference
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.User
import com.example.e_commerceapp.domain.useCases.UserLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: UserLoginUseCase) : ViewModel() {

    var userEmail = MutableLiveData<String>()
    var userPassword = MutableLiveData<String>()
    var confirmedUser = User()
    var observer = MutableLiveData(1)
    fun login() {


        viewModelScope.launch {
            if (userEmail.value?.isEmpty() == true || userPassword.value?.isEmpty() == true
            ) {
                return@launch
            } else {
                val user = User("", userEmail.value, userPassword.value)

                if (loginUseCase.loginUser(user)?.token != null) {

                    confirmedUser = loginUseCase.loginUser(user)!!
                    SharedPreference.writeStringFromSharedPreference("token", confirmedUser.token.toString())
                    observer.value = observer.value?.inc()
                    observer.value = observer.value?.dec()
                }


            }

        }

    }
}
/*

    // function to check internet connectivity ( returns true when internet is reliable and it will return false if not
    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager

        val activeNetwork: Network = connectivityManager.activeNetwork ?: return false
        val capabilities: NetworkCapabilities =
            connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

        return when { // return true if there is an internet connection from wifi, cellular and ethernet
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
 */