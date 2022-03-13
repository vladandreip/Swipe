package com.example.myapplication.features

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.myapplication.di.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

open class BaseFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    fun navigateSafe(destination: NavDirections) = findNavController().apply {
        currentDestination?.getAction(destination.actionId)?.let {
            navigate(destination)
        }
    }

}