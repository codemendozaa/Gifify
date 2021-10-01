package com.example.gifify.data.network

import com.example.gifify.data.model.GifsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getGifsByName(@Url url:String):Response<GifsResponse>


}