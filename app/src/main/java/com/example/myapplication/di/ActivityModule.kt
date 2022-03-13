package com.example.myapplication.di

import com.example.myapplication.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun mainActivity(): MainActivity
}