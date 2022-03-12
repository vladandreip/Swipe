package com.example.myapplication.features

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment

open class BaseFragment: DaggerFragment() {

    fun navigateSafe(destination: NavDirections) = findNavController().apply {
        currentDestination?.getAction(destination.actionId)?.let {
            navigate(destination)
        }
    }

}