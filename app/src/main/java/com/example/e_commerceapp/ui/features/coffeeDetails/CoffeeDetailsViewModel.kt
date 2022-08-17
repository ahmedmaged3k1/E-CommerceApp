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
    var selectedSugar1 = MutableLiveData<Int>(R.drawable.ic_sugar_svgrepo_com)
    val selectedSugar2 = MutableLiveData<Int>(R.drawable.ic_sugar_svgrepo_com__1_)
    val selectedSugar3 = MutableLiveData<Int>(R.drawable.ic_sugar_svgrepo_com__2_)
    var selectedSize1 = MutableLiveData<Int>(R.drawable.ic_cup_svgrepo_com)
    val selectedSize2 = MutableLiveData<Int>(R.drawable.ic_cup_svgrepo_com)
    val selectedSize3 = MutableLiveData<Int>(R.drawable.ic_cup_svgrepo_com)
    var coffeeCounter = MutableLiveData<Int>(0)
    var coffeePrice = MutableLiveData<Int>(0)
    var coffeeItem = Coffee()
    fun increaseCounter() {
        if (coffeeCounter.value == 0) {
            coffeePrice.value = 0
        }
        coffeeCounter.value = coffeeCounter.value?.inc()
        coffeePrice.value =
            ((coffeeCounter.value?.let { coffeePrice.value?.plus(coffeeItem.price!!) }))

    }

    fun decreaseCounter() {
        if (coffeeCounter.value == 0) {
            coffeePrice.value = 0
            coffeeCounter.value = 0
            return
        }
        coffeeCounter.value = coffeeCounter.value?.dec()
        coffeePrice.value =
            ((coffeeCounter.value?.let { coffeePrice.value?.minus((coffeeItem.price!!)) }))


    }

    fun onClick() {


    }

    fun onClickSugar1() {
        selectedSugar1.value = R.drawable.sugar_hover_1
        selectedSugar2.value = R.drawable.ic_sugar_svgrepo_com__1_
        selectedSugar3.value = R.drawable.ic_sugar_svgrepo_com__2_
    }

    fun onClickSugar2() {
        selectedSugar2.value = R.drawable.sugar_hover_2
        selectedSugar1.value = R.drawable.ic_sugar_svgrepo_com
        selectedSugar3.value = R.drawable.ic_sugar_svgrepo_com__2_
    }

    fun onClickSugar3() {
        selectedSugar3.value = R.drawable.sugar_hover_3
        selectedSugar1.value = R.drawable.ic_sugar_svgrepo_com
        selectedSugar2.value = R.drawable.ic_sugar_svgrepo_com__1_
    }
    fun onClickSize1() {
        selectedSize1.value = R.drawable.ic_cup_svgrepo_com_hover
        selectedSize2.value = R.drawable.ic_cup_svgrepo_com
        selectedSize3.value = R.drawable.ic_cup_svgrepo_com

    }

    fun onClickSize2() {
        selectedSize2.value = R.drawable.ic_cup_svgrepo_com_hover
        selectedSize1.value = R.drawable.ic_cup_svgrepo_com
        selectedSize3.value = R.drawable.ic_cup_svgrepo_com
    }

    fun onClickSize3() {
        selectedSize3.value = R.drawable.ic_cup_svgrepo_com_hover
        selectedSize2.value = R.drawable.ic_cup_svgrepo_com
        selectedSize1.value = R.drawable.ic_cup_svgrepo_com
    }
}