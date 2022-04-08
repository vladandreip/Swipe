package com.example.myapplication.features.listFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentListBinding
import com.example.myapplication.features.BaseFragment

class ListFragment: BaseFragment() {
    private lateinit var binding: FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = ArrayAdapter(requireContext(), R.layout.list_item, R.id.textView, mutableListOf(1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6))
        binding.list.setOnItemClickListener { _, _, _, _ ->
            Log.e("ITEMCLICKED", "ITEM")
        }
    }

}