package com.example.myapplication.utils.helpers

import kotlinx.coroutines.Job

fun Job.cancelIfActive() {
    if (isActive) cancel()
}