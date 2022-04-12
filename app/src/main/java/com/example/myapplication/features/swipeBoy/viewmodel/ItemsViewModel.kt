package com.example.myapplication.features.swipeBoy.viewmodel

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val title: String,
    val description: String
) : Parcelable

class ItemsViewModel
@Inject constructor() : ViewModel() {

    private val contents = mutableListOf(
        Item(
            title = "What is Lorem Ipsum 1",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard" +
                    " dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen " +
                    "book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged." +
                    " It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with " +
                    "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        ),
        Item(
            title = "What is Lorem Ipsum 2",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard" +
                    " dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen " +
                    "book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged." +
                    " It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with " +
                    "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        ),
        Item(
            title = "What is Lorem Ipsum 3",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard" +
                    " dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen " +
                    "book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged." +
                    " It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with " +
                    "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        ),
        Item(
            title = "What is Lorem Ipsum 4",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard" +
                    " dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen " +
                    "book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged." +
                    " It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with " +
                    "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        )
    )

    private var _items = MutableLiveData<List<Item>>().apply {
        value = contents
    }

    val items: LiveData<List<Item>>
        get() = _items

    fun remove(item: Item) {
        contents.remove(item)
        _items.value = contents
    }
}