package com.example.myapplication.di

import com.example.myapplication.features.dummy.view.DummyFragment
import com.example.myapplication.features.home.view.HomeFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindsHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun  bindsDummyFragment(): DummyFragment
}*/

@Module
abstract class FragmentModule