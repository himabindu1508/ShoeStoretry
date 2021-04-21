package com.udacity.shoestore.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.xml.validation.Validator

class LoginViewModel : ViewModel() {

    val email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

}