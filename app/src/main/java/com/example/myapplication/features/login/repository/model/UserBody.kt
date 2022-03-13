package com.example.myapplication.features.login.repository.model

data class UserBody(
    var name: String,
    var email: String,
    var gender: String = "male",
    var status: String = "active"
)
