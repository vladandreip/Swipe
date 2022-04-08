package com.example.myapplication.features

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

abstract class OnSwipeTouchListener(
    context: Context?,
): View.OnTouchListener {

    private val gestureDetector = GestureDetector(context, GestureListener())

    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    abstract fun swipeLeftToRight()

    companion object {
        private const val SWIPE_DISTANCE_THRESHOLD = 100
        private const val SWIPE_VELOCITY_THRESHOLD = 100
    }

    inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            val distanceX = e2.x - e1.x
            val distanceY = e2.y - e1.y
            if (abs(distanceX) > abs(distanceY) && abs(distanceX) > SWIPE_DISTANCE_THRESHOLD && abs(
                    velocityX
                ) > SWIPE_VELOCITY_THRESHOLD
            ) {
                if (distanceX > 0) swipeLeftToRight()
                return true
            }
            return false
        }
    }
}