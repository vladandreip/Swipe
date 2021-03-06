package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        FragmentModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }
}