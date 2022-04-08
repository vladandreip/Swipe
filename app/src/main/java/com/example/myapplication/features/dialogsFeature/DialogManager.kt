package com.example.myapplication.features.dialogsFeature

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DialogManager(private val lifecycle: Lifecycle) {

    fun setDialog(
        context: Context,
        titleId: Int,
        messageId: Int,
        style: Int,
        negativeButtonId: Int? = null,
        positiveButtonId: Int? = null,
        negativeAction: DialogInterface.OnClickListener? = null,
        positiveAction: DialogInterface.OnClickListener? = null
    ): Boolean {

        MaterialAlertDialogBuilder(context, style).run {
            setTitle(titleId)
            setMessage(messageId)
            negativeButtonId?.let { setNegativeButton(it, negativeAction) }
            positiveButtonId?.let { setPositiveButton(it, positiveAction) }
            addLifecycleEvent(create())
        }

        return true
    }

    private fun addLifecycleEvent(alertDialog: AlertDialog) {
        val dialogObserver = object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    source.lifecycle.removeObserver(this)
                    alertDialog.dismiss()
                }
            }
        }

        lifecycle.addObserver(dialogObserver)
        alertDialog.show()
    }

}