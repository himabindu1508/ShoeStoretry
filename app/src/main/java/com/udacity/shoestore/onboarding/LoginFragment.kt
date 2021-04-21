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
import timber.log.Timber

class LoginFragment : Fragment()
{
    private lateinit var binding : FragmentLoginBinding
    private lateinit var viewModel : LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragbinding = FragmentLoginBinding.inflate(inflater, container, false)
        binding = fragbinding
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        Timber.i("LoginFragment")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            loginViewModel = viewModel
            loginFragment = this@LoginFragment
        }
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