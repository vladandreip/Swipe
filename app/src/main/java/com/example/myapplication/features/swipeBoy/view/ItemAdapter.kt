package com.example.myapplication.features.swipeBoy.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.SwipeListItemBinding
import com.example.myapplication.features.swipeBoy.viewmodel.Item

class ItemAdapter: ListAdapter<Item, ItemAdapter.ItemViewHolder>(DiffCallback()), Swiper {

    lateinit var onDelete: (Item, Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(SwipeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false).root)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(item: Item) {
            SwipeListItemBinding.bind(itemView).apply {
                description.text = item.description
                title.text = item.title

                button.setOnClickListener {
                    onDelete(item, adapterPosition)
                }
            }
        }
    }

    override fun onSwipedFromEnd(viewHolder: RecyclerView.ViewHolder) {
        onDelete(getItem(viewHolder.adapterPosition), viewHolder.adapterPosition)
    }

    override fun onSwipedFromStart(viewHolder: RecyclerView.ViewHolder) {
        onDelete(getItem(viewHolder.adapterPosition), viewHolder.adapterPosition)
    }

    fun getItemFromAdapter(position: Int): Item = getItem(position)

    private class DiffCallback: DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }
}
