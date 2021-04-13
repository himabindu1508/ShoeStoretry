package com.udacity.shoestore.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import timber.log.Timber

class InstructionsFragmnet : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : FragmentInstructionsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)

        Timber.i("InstructionsFragmnet")

        binding.goToShopFromInstructions.setOnClickListener {
            findNavController().navigate(InstructionsFragmnetDirections.actionInstructionsFragmnetToShoeStoreFragment())
        }

        return binding.root
    }
}