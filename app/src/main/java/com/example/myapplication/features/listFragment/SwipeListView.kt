package com.example.myapplication.features.listFragment

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.ListView
import kotlin.math.abs

class SwipeListView(context: Context?, attrs: AttributeSet?) : ListView(context, attrs) {

    private var e2X = 0.0f
    private var e2Y = 0.0f
    private var e1X = 0.0f
    private var e1Y = 0.0f

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        when(ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                e1X = ev.x
                e1Y = ev.y
            }

            MotionEvent.ACTION_UP -> {
                e2X = ev.x
                e2Y = ev.y

                val distanceX = e2X - e1X
                val distanceY = e2Y - e1Y
                if (abs(distanceX) > abs(distanceY) && abs(distanceX) > SWIPE_DISTANCE_THRESHOLD) {
                    if (distanceX > 0) Log.e("MOTION", "SWIPELEFT")
                    return true
                }
            }
        }
        return super.onTouchEvent(ev)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return super.onInterceptTouchEvent(ev)
    }

    companion object {
        private const val SWIPE_DISTANCE_THRESHOLD = 100
        private const val SWIPE_VELOCITY_THRESHOLD = 100
    }


}