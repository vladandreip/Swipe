package com.example.myapplication.features.dispatcher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.DispatchFragmentBinding
import com.example.myapplication.features.BaseFragment

class DispatchFragment : BaseFragment() {
    private lateinit var binding: DispatchFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DispatchFragmentBinding.inflate(inflater, container, false)
        //binding.recycler.adapter = ArrayAdapter<Int>(requireContext(), android.R.layout.test_list_item, mutableListOf(1,2,3,5,6,7,8))
        return binding.root
    }


}