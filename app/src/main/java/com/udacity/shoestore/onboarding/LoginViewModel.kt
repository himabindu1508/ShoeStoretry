package com.udacity.shoestore.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.xml.validation.Validator

class LoginViewModel : ViewModel() {

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    fun onSigUpClicked()
    {
        Timber.i("onSigUpClicked")
    }

    fun onLogInClicked()
    {
        Timber.i("onLogInClicked")
        Timber.i("email = $email")
        Timber.i("password = ${password.toString()}")

    }
}