package com.example.myapplication.features.login.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.FragmentCreateUsernameBinding
import com.example.myapplication.features.BaseFragment
import com.example.myapplication.features.login.repository.model.UserBody
import com.example.myapplication.features.login.viewModel.CreateUsernameViewModel
import com.example.myapplication.networking.Success

/*
true : add the child view to parent RIGHT NOW
false: add the child view to parent NOT NOW. Later means when you call parent.addChild(child)
 */

class CreateUsernameFragment: BaseFragment() {
    private val viewModel: CreateUsernameViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentCreateUsernameBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //You should never pass attachToRoot as true when you are not responsible for adding the child
        binding = FragmentCreateUsernameBinding.inflate(inflater, container, false)
        viewModel.liveData.observe(viewLifecycleOwner, { result ->
            when(result) {
                is Success -> result.data.email?.let { Log.e("LOGGER", it) }
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.createUsername.setOnClickListener {
            viewModel.createUsername(
                UserBody(
                    binding.name.editText?.text.toString(),
                    binding.email.editText?.text.toString()
                )
            )
        }
    }
}