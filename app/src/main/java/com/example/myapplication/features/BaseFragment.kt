package com.example.myapplication.features

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.myapplication.di.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import java.lang.Exception

abstract class BaseFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var alertDialog: AlertDialog? = null

    fun navigateSafe(destination: NavDirections) = findNavController().apply {
        currentDestination?.getAction(destination.actionId)?.let {
            navigate(destination)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //view.setOnTouchListener(OnSwipeTouchListener(requireContext(), OnSwipeTouchListener().GestureListener()))
        view.setOnTouchListener(object: OnSwipeTouchListener(requireContext()) {
            override fun swipeLeftToRight() {
                Log.e("SWIPE", "SWIPE")
                backCallback.handleOnBackPressed()
            }

        })

        try {
            /*view.findViewById<ListView>(R.id.nesteScrollView).setOnTouchListener(object: OnSwipeTouchListener(requireContext()) {
                override fun swipeLeftToRight() {
                    backCallback.handleOnBackPressed()
                }

            })*/
        } catch (e: Exception) {

        }

        /*view.setOnTouchListener(object: OnSwipeTouchListener(requireContext()) {
            override fun swipeLeftToRight() {
                backCallback.handleOnBackPressed()
            }

        })*/
    }



    protected open val backCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            findNavController().popBackStack()
        }
    }

    //daca vine product si vrea un screen in care sa nu fie left swipe to dismiss
    protected fun configureOnBackPressed() {
        //metoda de init
        requireActivity().onBackPressedDispatcher.addCallback(this, backCallback)
    }

    protected fun configureOnBackSwipe() {

    }



    override fun onDestroyView() {
        alertDialog?.dismiss()
        super.onDestroyView()
    }

}