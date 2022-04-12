package com.example.myapplication.features.swipeBoy.view

import android.graphics.Canvas
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.features.swipeBoy.viewmodel.Item

//Difference between sending an interface and sending a method

interface Swiper {
    //{ } - poate nu vrem ca cineva sa le implementeze pe toate
    fun onSwipedFromEnd(viewHolder: RecyclerView.ViewHolder) { }
    fun onSwipedFromStart(viewHolder: RecyclerView.ViewHolder) { }

    data class Action(
        var color: Int,
        var text: String? = null,
        var icon: Drawable? = null
    )
}

fun RecyclerView.addSwipeEndListener(action: Swiper.Action, listener: Swiper) {
    val endHelper = ItemTouchHelper(SwipeFromEndCallback(action, listener))
    endHelper.attachToRecyclerView(this)
}

fun RecyclerView.addSwipeStartListener(action: Swiper.Action, listener: Swiper) {
    val startHelper = ItemTouchHelper(SwipeFromStartCallback(action, listener))
    startHelper.attachToRecyclerView(this)
}

class SwipeFromEndCallback(action: Swiper.Action, private val listener: Swiper): ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START) {

    private val colorDrawable = ColorDrawable(action.color)

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        //don't care
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        when(direction) {
            ItemTouchHelper.START -> {
                listener.onSwipedFromEnd(viewHolder)
            }
        }
    }

    override fun onChildDraw(
        canvas: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(canvas, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

        when {
            dX < 0 -> {
                swipingFromTheEnd(canvas, viewHolder.itemView, dX.toInt())
            }

            else -> {
                notSwiping(canvas)
            }
        }
    }

    private fun swipingFromTheEnd(canvas: Canvas, itemView: View, dX: Int) {
        colorDrawable.setBounds(
            itemView.right + dX,
            itemView.top,
            itemView.right,
            itemView.bottom
        )

        colorDrawable.draw(canvas)
    }

    private fun notSwiping(canvas: Canvas) {
        colorDrawable.setBounds(
            0,
            0,
            0,
            0
        )

        colorDrawable.draw(canvas)
    }
}

class SwipeFromStartCallback(action: Swiper.Action, private val listener: Swiper): ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.END) {

    private val colorDrawable = ColorDrawable(action.color)

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        //don't care
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        when(direction) {
            ItemTouchHelper.END -> {
                listener.onSwipedFromStart(viewHolder)
            }
        }
    }

    override fun onChildDraw(
        canvas: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(canvas, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

        when {
            dX > 0 -> {
                swipingFromTheStart(canvas, viewHolder.itemView, dX.toInt())
            }

            else -> {
                notSwiping(canvas)
            }
        }
    }

    private fun swipingFromTheStart(canvas: Canvas, itemView: View, dX: Int) {
        colorDrawable.setBounds(
            itemView.left,
            itemView.top,
            itemView.left + dX,
            itemView.bottom
        )
        //

        colorDrawable.draw(canvas)
    }

    private fun notSwiping(canvas: Canvas) {
        colorDrawable.setBounds(
            0,
            0,
            0,
            0
        )

        colorDrawable.draw(canvas)
    }
}


//////////////////////////////////////////////////////----------------------------------//////////////////////////////////////////////////////

fun RecyclerView.addSwipeEndListener2(itemAdapter: ItemAdapter, onDelete: (item: Item) -> Unit) {
    val callback = SwipeFromEndCallBack2(itemAdapter, onDelete)
    val helper = ItemTouchHelper(callback)
    helper.attachToRecyclerView(this)
}

class SwipeFromEndCallBack2(private val itemAdapter: ItemAdapter, private var onDelete: (item: Item) -> Unit): ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        //don't care
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        when(direction) {
            ItemTouchHelper.START -> {
                onDelete(itemAdapter.getItemFromAdapter(viewHolder.adapterPosition))
            }
        }
    }
}