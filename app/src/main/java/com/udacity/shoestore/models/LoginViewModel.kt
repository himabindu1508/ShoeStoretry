package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel : ViewModel()
{
    private val _userLoggedIn = MutableLiveData<Boolean>()
    val userLoggedIn : LiveData<Boolean>
    get() = _userLoggedIn

    private val _newUserLoggedIn = MutableLiveData<Boolean>()
    val newUserLoggedIn : LiveData<Boolean>
    get() = _newUserLoggedIn

    //credentials object
    var credentials : LoginCredentials

    init{
        credentials = LoginCredentials("", "")
        _newUserLoggedIn.value = false
        _userLoggedIn.value = false
    }

    fun reInitCredentials(){
        credentials = LoginCredentials("", "")
    }

    fun onLoginBtClicked(){
        _userLoggedIn.value = true
    }

    fun onNewUserBtClicked(){
        _newUserLoggedIn.value = true
    }

    fun resetNavVars(){
        _newUserLoggedIn.value = false
        _userLoggedIn.value = false
    }
}