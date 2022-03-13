package com.example.myapplication.features.login.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.features.login.repository.CreateUsernameRepository
import com.example.myapplication.features.login.repository.model.ApiUser
import com.example.myapplication.features.login.repository.model.UserBody
import com.example.myapplication.networking.Result
import com.example.myapplication.networking.Success
import com.example.myapplication.utils.helpers.cancelIfActive
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CreateUsernameViewModel @Inject constructor() : ViewModel() {
    private val repository: CreateUsernameRepository = CreateUsernameRepository()
    private var job: Job? = null

    private val mutableLiveData: MutableLiveData<Result<ApiUser>> = MutableLiveData()

    val liveData: LiveData<Result<ApiUser>>
        get() = mutableLiveData

    fun createUsername(user: UserBody) {
        job?.cancelIfActive()
        job = viewModelScope.launch {
            repository.createUsername(user).collect { result ->
                when(result) {
                    is Success -> {
                        mutableLiveData.value = result
                    }
                }
            }
        }
    }
}