package com.saadahmedev.baseboilerplate.api

import com.google.gson.GsonBuilder
import com.saadahmedev.baseboilerplate.util.Constants.Api.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {

    private val gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val retrofitInstance: ApiEndpoints by lazy {
        retrofit.create(ApiEndpoints::class.java)
    }
}