package com.example.myapplication.features.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentUsersBinding
import com.example.myapplication.features.BaseFragment
import com.example.myapplication.utils.helpers.EMPTY_STRING

class UsersFragment: BaseFragment() {
    lateinit var binding: FragmentUsersBinding
    private var patientAge = 0
    private var patientName = EMPTY_STRING

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        arguments?.let {
            UsersFragmentArgs.fromBundle(it).apply {
                patientAge = age
                patientName = name ?: patientName
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }



}