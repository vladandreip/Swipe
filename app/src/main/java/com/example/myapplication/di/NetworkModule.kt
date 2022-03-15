package com.example.myapplication.di

import com.example.myapplication.features.login.repository.CreateUsernameServiceApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideCreateUsernameService(): CreateUsernameServiceApi {
        return CreateUsernameServiceApi.create()
    }
}