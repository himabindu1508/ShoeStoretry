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
    private val sharedViewModel : ShoeStoreViewModel by activityViewModels()
    private var binding : FragmentAddNewShoeBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragBinding = FragmentAddNewShoeBinding.inflate(inflater, container, false)
        binding = fragBinding

        Timber.i("AddNewShowFragment")

        sharedViewModel.eventOnCancel.observe(viewLifecycleOwner, Observer {
            //saveComplete()
            findNavController().navigate(AddNewShowFragmentDirections.actionAddNewShowFragmentToShoeStoreFragment())
        })

        sharedViewModel.eventOnSave.observe(viewLifecycleOwner, Observer {
            //saveComplete()
            findNavController().navigate(AddNewShowFragmentDirections.actionAddNewShowFragmentToShoeStoreFragment())
        })

        return fragBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            sharedViewModel = sharedViewModel
            addNewShoeFragment = this@AddNewShowFragment
        }
    }

    fun saveComplete(){
        findNavController().navigate(AddNewShowFragmentDirections.actionAddNewShowFragmentToShoeStoreFragment())
    }
}