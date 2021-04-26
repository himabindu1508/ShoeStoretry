package com.udacity.shoestore.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.LoginViewModel
import timber.log.Timber

class LoginFragment : Fragment()
{
    private lateinit var binding : FragmentLoginBinding
    private lateinit var viewModel : LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login ,container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel
        binding.setLifecycleOwner(this)

        binding.loginCreds = viewModel.credentials
        viewModel.reInitCredentials()

        viewModel.userLoggedIn.observe(viewLifecycleOwner, Observer { isLogInClicked ->
            if(isLogInClicked)
            {
                onLogInClicked()
                viewModel.resetNavVars()
            }
        })

        viewModel.newUserLoggedIn.observe(viewLifecycleOwner, Observer { isNewUserClicked ->
            if(isNewUserClicked)
            {
                onSigUpClicked()
                viewModel.resetNavVars()
            }
        })

        Timber.i("LoginFragment")

        return binding.root
    }

    fun onSigUpClicked()
    {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }

    fun onLogInClicked()
    {
        Timber.i("onLogInClicked")
        //No database to check login credentials so do nothing for now
    }
}