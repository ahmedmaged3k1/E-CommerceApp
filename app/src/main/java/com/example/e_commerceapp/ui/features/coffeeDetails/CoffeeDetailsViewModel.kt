package com.example.e_commerceapp.ui.features.coffeeDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerceapp.R
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.Coffee

class CoffeeDetailsViewModel : ViewModel() {

    val smallSizePrice = 5
    val mediumSizePrice = 10
    val largeSizePrice = 15
    val smallSugarPrice = 5
    val mediumSugarPrice = 10
    val largeSugarPrice = 15

    val selectedSugar1: Int = R.drawable.ic_sugar_svgrepo_com
    val selectedSugar2: Int = R.drawable.ic_sugar_svgrepo_com__1_
    val selectedSugar3: Int = R.drawable.ic_sugar_svgrepo_com__2_
    val selectedSize: Int = R.drawable.ic_cup_svgrepo_com



    var coffeeCounter = MutableLiveData<Int>(0)


    var coffeeItem = MutableLiveData<Coffee>()
    fun increaseCounter() {
        coffeeCounter.value = coffeeCounter.value?.inc()

    }

    fun decreaseCounter() {
        if (coffeeCounter.value == 0) return
        coffeeCounter.value = coffeeCounter.value?.dec()


    }

    fun onClick() {


    }
}