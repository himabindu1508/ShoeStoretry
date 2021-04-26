package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.formatShoes
import timber.log.Timber

class ShoeStoreViewModel : ViewModel()
{
    // {1} : Variables --> Navigate to new shoe add fragment
    private val _navigateToAddNewShoe = MutableLiveData<Boolean?>()
    val navigateToAddNewShoe : LiveData<Boolean?>
    get() = _navigateToAddNewShoe

    private val _shoeList = MutableLiveData(mutableListOf<Shoe>())
    val shoeList : LiveData<MutableList<Shoe>>
    get() = _shoeList

    private val _eventOnSave = MutableLiveData<Boolean>()
    val eventOnSave : LiveData<Boolean>
    get() = _eventOnSave

    private val _eventOnCancel = MutableLiveData<Boolean>()
    val eventOnCancel : LiveData<Boolean>
    get() = _eventOnCancel

    //shoe var
    var boundShoe: Shoe

    //Textview string
    var shoesString = Transformations.map(shoeList) { shoes ->
        formatShoes(shoes)
    }

    init {
        _eventOnSave.value = false
        _eventOnCancel.value = false
        _navigateToAddNewShoe.value = false

        boundShoe = Shoe("", 0.0, "", "")
        initShoeList()
    }

    //Populate list of shoes
    private fun initShoeList() {

        val shoeAnkle = Shoe("Ankle Boots", 9.0 , "Inc .5",  "Boots")
        val shoeBallet = Shoe("Ballet Shoe", 6.0 , "Gucci", "La la la")

        _shoeList.value?.add(shoeAnkle)
        _shoeList.value?.add(shoeBallet)
    }

    fun reInitShoe() {
        boundShoe =  Shoe("", 0.0, "", "")
    }

    //{1} : Functions --> Navigate to new shoe add fragment
    fun onAddNewShowClicked() {
        _navigateToAddNewShoe.value = true
    }

    fun resetNavigateToAddNewShoe() {
        _navigateToAddNewShoe.value = false
    }

    //{2} : Function --> Add new show
     fun addNewShoeToList(newShoe : Shoe) {
        Timber.i("Shoe : ${newShoe.name} + ${newShoe.company} + ${newShoe.description} + ${newShoe.size}")
        _shoeList.value?.add(newShoe)
        _eventOnSave.value = true
        updateStoreUI()
    }

    fun updateStoreUI(){
        shoesString = Transformations.map(shoeList) { shoes ->
            formatShoes(shoes)
        }
    }

    fun cancelClicked() {
        _eventOnCancel.value = true
    }

    fun resetSaveCancelVars() {
        _eventOnSave.value = false
        _eventOnCancel.value = false
    }

}