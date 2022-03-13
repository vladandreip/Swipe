package com.example.myapplication.features.login.repository

import com.example.myapplication.features.login.repository.model.ApiUser
import com.example.myapplication.features.login.repository.model.UserBody
import com.example.myapplication.networking.Failure
import com.example.myapplication.networking.Result
import com.example.myapplication.networking.Success
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

class CreateUsernameRepository(
    private val api: CreateUsernameServiceApi =  CreateUsernameServiceApi.get()
) {

    fun createUsername(user: UserBody): Flow<Result<ApiUser>> = flow {
        emit(fetchCreateUsername(user))
    }

    private suspend fun fetchCreateUsername(user: UserBody) =
        api.createUsername(user).run {
            if (isSuccessful) {
                body()?.let {
                    Success(data = it)
                } ?: Failure(Exception())
            } else {
                Failure(Exception())
            }

        }
}