package com.example.myapplication.di

import com.example.myapplication.features.dialogsFeature.DestinationFragment
import com.example.myapplication.features.dialogsFeature.EntryFragment
import com.example.myapplication.features.dispatcher.DispatchFragment
import com.example.myapplication.features.dummy.view.DummyFragment
import com.example.myapplication.features.home.view.HomeFragment
import com.example.myapplication.features.listFragment.ListFragment
import com.example.myapplication.features.login.view.CreateUsernameFragment
import com.example.myapplication.features.recyclerFragment.RecyclerFragment
import com.example.myapplication.features.swipeBoy.view.ItemsFragment
import com.example.myapplication.features.users.UsersFragment
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

    @ContributesAndroidInjector
    abstract fun entryFragment(): EntryFragment

    @ContributesAndroidInjector
    abstract fun destinationFragment(): DestinationFragment

    @ContributesAndroidInjector
    abstract fun dispatchFragment(): DispatchFragment

    @ContributesAndroidInjector
    abstract fun listFragment(): ListFragment

    @ContributesAndroidInjector
    abstract fun recyclerFragment(): RecyclerFragment

    @ContributesAndroidInjector
    abstract fun itemsFragment(): ItemsFragment

}
