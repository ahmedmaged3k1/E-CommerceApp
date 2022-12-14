package com.example.e_commerceapp.ui.features.coffeeDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.R
import com.example.e_commerceapp.data.dataSource.localDataSource.entities.CoffeeCart
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.Coffee
import com.example.e_commerceapp.domain.useCases.CartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeDetailsViewModel @Inject constructor(private val cartUseCase: CartUseCase) :
    ViewModel() {

    private val smallSizePrice = 5
    private val mediumSizePrice = 10
    private val largeSizePrice = 15
    private val smallSugarPrice = 3
    private val mediumSugarPrice = 5
    private val largeSugarPrice = 7
    var observer = MutableLiveData(1)
    var selectedSugar1 = MutableLiveData(R.drawable.ic_sugar_svgrepo_com)
    val selectedSugar2 = MutableLiveData(R.drawable.ic_sugar_svgrepo_com__1_)
    val selectedSugar3 = MutableLiveData(R.drawable.ic_sugar_svgrepo_com__2_)
    var selectedSize1 = MutableLiveData(R.drawable.ic_cup_svgrepo_com)
    val selectedSize2 = MutableLiveData(R.drawable.ic_cup_svgrepo_com)
    val selectedSize3 = MutableLiveData(R.drawable.ic_cup_svgrepo_com)
    var coffeeCounter = MutableLiveData(0)
    var coffeePrice = MutableLiveData(0)
    var coffeeItem = Coffee()

    private val coffeeList = MutableLiveData<MutableList<Coffee>>()
    private val cartItem = mutableListOf<Coffee>()
    private var selectedSugar = 0
    private var selectedSize = 0
    var coffeeCart = CoffeeCart(
        Math.random().toInt(),
        coffeeItem.id, coffeeItem.productName, "", coffeeItem.price,
        coffeeItem.description, coffeeItem.image, coffeeItem.sugar, coffeeItem.size
    )

    fun increaseCounter() {
        if (coffeeCounter.value == 0) {
            coffeePrice.value = 0
        }
        coffeeCounter.value = coffeeCounter.value?.inc()
        coffeePrice.value =
            ((coffeeCounter.value?.let {
                coffeePrice.value?.plus(coffeeItem.price!!)?.toInt() ?: 0
            }))

    }

    fun decreaseCounter() {
        if (coffeeCounter.value == 0) {
            coffeePrice.value = 0
            coffeeCounter.value = 0
            return
        }
        coffeeCounter.value = coffeeCounter.value?.dec()
        coffeePrice.value =
            ((coffeeCounter.value?.let {
                coffeePrice.value?.minus((coffeeItem.price!!))?.toInt() ?: 0
            }))


    }

    fun onClickSugar1() {
        selectedSugar1.value = R.drawable.sugar_hover_1
        selectedSugar2.value = R.drawable.ic_sugar_svgrepo_com__1_
        selectedSugar3.value = R.drawable.ic_sugar_svgrepo_com__2_
        selectedSugar = 0
        coffeePrice.value = ((coffeeCounter.value?.let { coffeePrice.value?.plus(smallSizePrice) }))
    }

    fun onClickSugar2() {
        selectedSugar2.value = R.drawable.sugar_hover_2
        selectedSugar1.value = R.drawable.ic_sugar_svgrepo_com
        selectedSugar3.value = R.drawable.ic_sugar_svgrepo_com__2_
        selectedSugar = 1
        coffeePrice.value =
            ((coffeeCounter.value?.let { coffeePrice.value?.plus(mediumSizePrice) }))
    }

    fun onClickSugar3() {
        selectedSugar3.value = R.drawable.sugar_hover_3
        selectedSugar1.value = R.drawable.ic_sugar_svgrepo_com
        selectedSugar2.value = R.drawable.ic_sugar_svgrepo_com__1_
        coffeePrice.value =
            ((coffeeCounter.value?.let { coffeePrice.value?.plus(largeSizePrice) }))
    }

    fun onClickSize1() {
        selectedSize1.value = R.drawable.ic_cup_svgrepo_com_hover
        selectedSize2.value = R.drawable.ic_cup_svgrepo_com
        selectedSize3.value = R.drawable.ic_cup_svgrepo_com
        selectedSize = 0
        coffeePrice.value =
            ((coffeeCounter.value?.let { coffeePrice.value?.plus(smallSugarPrice) }))


    }

    fun onClickSize2() {
        selectedSize2.value = R.drawable.ic_cup_svgrepo_com_hover
        selectedSize1.value = R.drawable.ic_cup_svgrepo_com
        selectedSize3.value = R.drawable.ic_cup_svgrepo_com
        selectedSize = 1
        ((coffeeCounter.value?.let { coffeePrice.value?.minus(mediumSugarPrice) }))
        coffeePrice.value =
            ((coffeeCounter.value?.let { coffeePrice.value?.plus(mediumSugarPrice) }))
    }

    fun onClickSize3() {
        selectedSize3.value = R.drawable.ic_cup_svgrepo_com_hover
        selectedSize2.value = R.drawable.ic_cup_svgrepo_com
        selectedSize1.value = R.drawable.ic_cup_svgrepo_com
        selectedSize = 2
        ((coffeeCounter.value?.let { coffeePrice.value?.minus(largeSugarPrice) }))
        coffeePrice.value =
            ((coffeeCounter.value?.let { coffeePrice.value?.plus(largeSugarPrice) }))
    }

    fun addToCart() {
        coffeeCart.price = coffeePrice.value?.toFloat()
        coffeeCart.id = coffeeItem.id
        coffeeCart.productName = coffeeItem.productName
        coffeeCart.description = coffeeItem.description
        coffeeCart.image = coffeeItem.image
        coffeeCart.sugar = coffeeItem.sugar
        coffeeCart.size = coffeeItem.size

        cartItem.add(coffeeItem)
        coffeeList.value = cartItem
        viewModelScope.launch {
            cartUseCase.addItem(coffeeCart)
            observer.value = observer.value?.inc()
            observer.value = observer.value?.dec()
        }
    }

}