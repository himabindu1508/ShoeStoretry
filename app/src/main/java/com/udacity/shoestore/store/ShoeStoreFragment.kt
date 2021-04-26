package com.udacity.shoestore.store

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
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

        binding.shoeStoreViewModel = sharedViewModel
        binding.setLifecycleOwner(this)

        sharedViewModel.navigateToAddNewShoe.observe(viewLifecycleOwner, Observer {
            if(it == true)
            {
                findNavController().navigate(ShoeStoreFragmentDirections.actionShoeStoreFragmentToAddNewShowFragment())
                sharedViewModel.resetNavigateToAddNewShoe()
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.login_Fragment)
        {
            findNavController().navigate(ShoeStoreFragmentDirections.actionShoeStoreFragmentToLoginFragment())
        }
        //return (NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item))
        return (super.onOptionsItemSelected(item))
    }

}