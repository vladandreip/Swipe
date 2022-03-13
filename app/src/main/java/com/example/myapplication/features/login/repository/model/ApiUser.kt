package com.example.myapplication.features.login.repository.model

import androidx.annotation.Keep

@Keep
data class ApiUser(
    var id: String?,
    var name: String?,
    var email: String?,
    var gender: String?,
    var status: String?
)