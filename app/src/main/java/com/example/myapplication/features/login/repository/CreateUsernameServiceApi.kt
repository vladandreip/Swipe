package com.example.myapplication.features.login.repository

import com.example.myapplication.features.login.repository.model.ApiUser
import com.example.myapplication.features.login.repository.model.UserBody
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateUsernameServiceApi {

    @POST(CREATE_USERNAME_URL)
    suspend fun createUsername(
        @Body user: UserBody
    ): Response<ApiUser>

    companion object {
        private const val CREATE_USERNAME_URL = "users"
        
        private fun getAuthInterceptor() = Interceptor { chain ->  
            chain.proceed(
                chain
                    .request()
                    .newBuilder()
                    //.addHeader("Authorization", Credentials.basic("usernae", "password"))
                    .addHeader("Authorization", "Bearer f0261588fc3554555d934c599d97140d2e7ec1519fc4c60a7a271d8c5856ff73")
                    .build()
            )
        }

        private fun getLoggingInterceptor() = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        fun get(): CreateUsernameServiceApi =
            Retrofit.Builder()
                .baseUrl("https://gorest.co.in/public/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient
                    .Builder()
                    .addInterceptor(getAuthInterceptor())
                    .addInterceptor(getLoggingInterceptor())
                    .build()
                )
                .build()
                .create(CreateUsernameServiceApi::class.java)
    }
}