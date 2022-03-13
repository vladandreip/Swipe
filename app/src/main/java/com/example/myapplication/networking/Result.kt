package com.example.myapplication.networking

sealed class Result<out T: Any>

//class Failure<T>(): Result()

class Failure(
    val exception: Exception
) : Result<Nothing>()

class Success<T : Any>(
    val data: T
) : Result<T>()

class Loading(isLoading: Boolean) : Result<Nothing>()

