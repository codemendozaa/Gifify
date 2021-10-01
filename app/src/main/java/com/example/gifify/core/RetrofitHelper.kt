package com.example.gifify.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.giphy.com/v1/gifs/search?q=SEARCH%20TERM&")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}