package com.example.myapplication.di

import com.example.myapplication.features.dummy.view.DummyFragment
import com.example.myapplication.features.home.view.HomeFragment
import com.example.myapplication.features.login.view.CreateUsernameFragment
import com.example.myapplication.features.users.UsersFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun dummyFragment(): DummyFragment

    @ContributesAndroidInjector
    abstract fun createUsernameFragment(): CreateUsernameFragment

    @ContributesAndroidInjector
    abstract fun usersFragment(): UsersFragment

}
