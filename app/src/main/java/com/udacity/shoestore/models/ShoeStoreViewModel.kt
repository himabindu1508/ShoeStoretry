package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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

    init {
        _eventOnSave.value = false
        _eventOnCancel.value = false
        _navigateToAddNewShoe.value = false
    }

    //{1} : Functions --> Navigate to new shoe add fragment
    fun onAddNewShowClicked(){
        _navigateToAddNewShoe.value = true
    }

    //{2} : Function --> Add new show
     fun addNewShoeToList(newShoe : Shoe){
        _shoeList.value?.add(newShoe)
        _eventOnSave.value = true
    }

    fun cancelClicked(){
        _eventOnCancel.value = true;
    }


}