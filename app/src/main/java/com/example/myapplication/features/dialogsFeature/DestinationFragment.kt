package com.example.myapplication.features.dialogsFeature

import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentDestinationBinding
import com.example.myapplication.features.BaseFragment

class DestinationFragment: BaseFragment() {
    private lateinit var binding: FragmentDestinationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDestinationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureOnBackPressed()
    }

    override fun onResume() {
        super.onResume()
        //dispatchMotionEvent()
    }

    private fun dispatchMotionEvent() {

        val originalDownTime: Long = SystemClock.uptimeMillis()
        val eventTime: Long = SystemClock.uptimeMillis() + 100

        val motionEvent = MotionEvent.obtain(
            originalDownTime,
            eventTime,
            MotionEvent.ACTION_MOVE,
            50.0F,
            50.0F,
            0
        )

        view?.dispatchTouchEvent(motionEvent)
        activity?.dispatchTouchEvent(motionEvent)
    }
}