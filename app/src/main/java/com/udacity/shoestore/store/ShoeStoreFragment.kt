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
import com.udacity.shoestore.databinding.FragmentShoeStoreBinding
import com.udacity.shoestore.models.ShoeStoreViewModel
import timber.log.Timber

class ShoeStoreFragment : Fragment()
{
    private val sharedViewModel : ShoeStoreViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding :FragmentShoeStoreBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_store, container, false)

        Timber.i("ShoeStoreFragment")

        binding.shoeStoreViewModel = sharedViewModel
        binding.setLifecycleOwner(this)

        val adapter = ShoeStoreAdapter()
        binding.shoeRcView.adapter = adapter

        sharedViewModel.shoeList.observe(viewLifecycleOwner, Observer{
            it?.let{
                adapter.data = it
            }
        })

        sharedViewModel.navigateToAddNewShoe.observe(viewLifecycleOwner, Observer {
            findNavController().navigate(ShoeStoreFragmentDirections.actionShoeStoreFragmentToAddNewShowFragment())
        })

        return binding.root
    }

}