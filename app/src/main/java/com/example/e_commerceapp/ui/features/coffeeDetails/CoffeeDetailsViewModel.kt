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


<<<<<<< HEAD
class CoffeeDetailsViewModel () :
    ViewModel() {


    private val smallSizePrice = 5
    private val mediumSizePrice = 10
    private val largeSizePrice = 15
    private val smallSugarPrice = 3
    var observer = MutableLiveData<Int>(1)
    private val mediumSugarPrice = 5
    private val largeSugarPrice = 7
    var selectedSugar1 = MutableLiveData(R.drawable.ic_sugar_svgrepo_com)
    val selectedSugar2 = MutableLiveData(R.drawable.ic_sugar_svgrepo_com__1_)
    val selectedSugar3 = MutableLiveData(R.drawable.ic_sugar_svgrepo_com__2_)
    var selectedSize1 = MutableLiveData(R.drawable.ic_cup_svgrepo_com)
    val selectedSize2 = MutableLiveData(R.drawable.ic_cup_svgrepo_com)
    val selectedSize3 = MutableLiveData(R.drawable.ic_cup_svgrepo_com)
    private var selectedSugar = 0
    private var selectedSize = 0

    var coffeeCounter = MutableLiveData(0)
    var coffeePrice = MutableLiveData(0)
=======
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


>>>>>>> parent of e9b546d (Details fragment data binding)
    var coffeeItem = Coffee()
    var coffeeCart = CoffeeCart(
        coffeeItem.id, coffeeItem.productName, "", coffeeItem.price,
        coffeeItem.description, coffeeItem.image, coffeeItem.sugar, coffeeItem.size
    )

    fun increaseCounter() {
        if (coffeeCounter.value == 0) {
            coffeePrice.value=0
        }
        coffeeCounter.value = coffeeCounter.value?.inc()
        coffeePrice.value=((coffeeCounter.value?.let { coffeePrice.value?.plus( coffeeItem.price!!) }))

    }

    fun decreaseCounter() {
        if (coffeeCounter.value == 0) {
            coffeePrice.value=0
            coffeeCounter.value = 0
            return
        }
        coffeeCounter.value = coffeeCounter.value?.dec()
        coffeePrice.value=((coffeeCounter.value?.let { coffeePrice.value?.minus((coffeeItem.price!!)) }))



    }

<<<<<<< HEAD
    fun onClickSugar1() {
        selectedSugar1.value = R.drawable.sugar_hover_1
        selectedSugar2.value = R.drawable.ic_sugar_svgrepo_com__1_
        selectedSugar3.value = R.drawable.ic_sugar_svgrepo_com__2_
        selectedSugar = 0
        coffeePrice.value =
            ((coffeeCounter.value?.let { coffeePrice.value?.plus(smallSizePrice) }))
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
        selectedSugar = 2
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
        coffeeCart.price = coffeePrice.value
        viewModelScope.launch {

            observer.value = observer.value?.inc()
            observer.value = observer.value?.dec()
        }
    }


    /*private fun calculatePrice():Int{
        return
    }*/
=======
    fun onClick() {


    }
>>>>>>> parent of e9b546d (Details fragment data binding)
}