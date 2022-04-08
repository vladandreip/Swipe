package com.example.myapplication.features.recyclerFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemBinding

class RecyclerAdapter (
): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false).root)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        ListItemBinding.bind(holder.itemView).apply {
            button.setOnClickListener {
                Log.e("BUTTON", "CLICK")
            }
        }

        /*holder.itemView.setOnClickListener {
            Log.e("ITEMVIEW", "CLICK")
        }*/
    }

    override fun getItemCount(): Int = 15
}

class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)