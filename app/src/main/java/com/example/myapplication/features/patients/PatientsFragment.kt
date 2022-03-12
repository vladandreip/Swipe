package com.example.myapplication.features.patients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentPatientsBinding
import com.example.myapplication.features.BaseFragment
import com.example.myapplication.utils.helpers.EMPTY_STRING

class PatientsFragment: BaseFragment() {
    lateinit var binding: FragmentPatientsBinding
    private var patientAge = 0
    private var patientName = EMPTY_STRING

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPatientsBinding.inflate(inflater, container, false)
        arguments?.let {
            PatientsFragmentArgs.fromBundle(it).apply {
                patientAge = age
                patientName = name ?: patientName
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }



}