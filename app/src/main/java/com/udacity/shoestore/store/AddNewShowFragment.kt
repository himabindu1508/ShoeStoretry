   package com.udacity.shoestore.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddNewShoeBinding
import com.udacity.shoestore.models.ShoeStoreViewModel
import timber.log.Timber

class AddNewShowFragment : Fragment()
{
    private val viewModel : ShoeStoreViewModel by activityViewModels()
    private var binding : FragmentAddNewShoeBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragBinding = FragmentAddNewShoeBinding.inflate(inflater, container, false)
        binding = fragBinding

        viewModel.eventOnCancel.observe(viewLifecycleOwner, Observer {isCancelled ->
            if(isCancelled)
            {
                saveComplete()
                viewModel.resetSaveCancelVars()
            }
        })

        viewModel.eventOnSave.observe(viewLifecycleOwner, Observer {
            if(it)
            {
                saveComplete()
                viewModel.resetSaveCancelVars()
            }
        })

        fragBinding.shoeVar = viewModel.boundShoe

        return fragBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.reInitShoe()

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            sharedViewModel = viewModel
            shoeVar = viewModel.boundShoe
            addNewShoeFragment = this@AddNewShowFragment
        }
    }

    fun saveComplete(){
        findNavController().navigate(AddNewShowFragmentDirections.actionAddNewShowFragmentToShoeStoreFragment())
    }
}