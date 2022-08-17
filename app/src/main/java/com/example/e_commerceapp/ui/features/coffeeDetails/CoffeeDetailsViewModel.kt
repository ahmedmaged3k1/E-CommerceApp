package com.example.e_commerceapp.ui.features.coffeeDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerceapp.R
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.Coffee

class CoffeeDetailsViewModel : ViewModel() {

    val smallSizePrice = 5
    val mediumSizePrice = 10
    val largeSizePrice = 15
    val smallSugarPrice = 3
    val mediumSugarPrice = 5
    val largeSugarPrice = 7

    val selectedSugar1: Int = R.drawable.ic_sugar_svgrepo_com
    val selectedSugar2: Int = R.drawable.ic_sugar_svgrepo_com__1_
    val selectedSugar3: Int = R.drawable.ic_sugar_svgrepo_com__2_
    val selectedSize: Int = R.drawable.ic_cup_svgrepo_com


    var coffeeCounter = MutableLiveData<Int>(0)
    var coffeePrice = MutableLiveData<Int>(0)


    var coffeeItem = Coffee()
    fun increaseCounter() {
        if (coffeeCounter.value == 0) {
            coffeePrice.value=0
        }
        coffeeCounter.value = coffeeCounter.value?.inc()
        coffeePrice.value=((coffeeCounter.value?.let { coffeePrice.value?.plus(it* coffeeItem.price!!) }))

    }

    fun decreaseCounter() {
        if (coffeeCounter.value == 1) {
            coffeePrice.value=0
            return
        }
        coffeeCounter.value = coffeeCounter.value?.dec()
        coffeePrice.value=((coffeeCounter.value?.let { coffeePrice.value?.minus(it* coffeeItem.price!!) }))


    }

    fun onClick() {


    }
}