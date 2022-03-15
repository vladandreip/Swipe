package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemSuperuserBinding
import com.example.myapplication.databinding.ItemUserBinding
import java.util.LinkedList
import java.util.Queue
import okio.blackholeSink

class UserAdapter(
    var userList: List<String>
): RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return if(viewType == USER_TYPE) {
            UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false).root)
        } else {
            UserViewHolder(ItemSuperuserBinding.inflate(LayoutInflater.from(parent.context), parent, false).root)
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        when(holder.itemViewType) {
            USER_TYPE -> ItemUserBinding.bind(holder.itemView).apply {

            }

            SUPERUSER_TYPE -> ItemSuperuserBinding.bind(holder.itemView).apply {

            }
        }
    }

    override fun getItemCount(): Int = userList.size

    override fun getItemViewType(position: Int): Int {
        if (userList[position] == "user") return USER_TYPE
        return SUPERUSER_TYPE
    }

    companion object {
        const val USER_TYPE = 0
        const val SUPERUSER_TYPE = 1
    }

}

class UserViewHolder(view: View): RecyclerView.ViewHolder(view)