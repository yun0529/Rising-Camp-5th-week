package com.example.rc3b5week

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TourRetrofitClient {
    val tRetrofit = initRetrofit()
    private const val URL = "http://api.visitjeju.net/vsjApi/contents/"

    private fun initRetrofit() : Retrofit =
        Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
