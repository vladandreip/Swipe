package com.example.myapplication.features.dialogsFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentEntryBinding
import com.example.myapplication.features.BaseFragment

class EntryFragment: BaseFragment() {

    private lateinit var binding: FragmentEntryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            navigateSafe(EntryFragmentDirections.toDestinationFragment())
        }

        binding.button2.setOnClickListener {
            navigateSafe(EntryFragmentDirections.toDispatchFragment())
        }

        binding.button3.setOnClickListener {
            navigateSafe(EntryFragmentDirections.toListFragment())
        }

        binding.button4.setOnClickListener {
            navigateSafe(EntryFragmentDirections.toRecyclerFragment())
        }

        /*GlobalScope.launch(Dispatchers.Main) {
            delay(1500)
            navigateSafe(EntryFragmentDirections.toDestinationFragment())
        }*/
    }
}