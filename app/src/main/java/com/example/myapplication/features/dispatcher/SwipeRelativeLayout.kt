package com.example.myapplication.features.dispatcher

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.RelativeLayout

class SwipeRelativeLayout(
    context: Context?,
    attrs: AttributeSet?,
) : RelativeLayout(context, attrs) {

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}