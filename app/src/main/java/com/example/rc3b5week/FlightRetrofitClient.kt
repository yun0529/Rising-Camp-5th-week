package com.example.rc3b5week

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FlightRetrofitClient {
    val fRetrofit = initRetrofit()
    private const val URL = "http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/"
    private fun initRetrofit() : Retrofit =
        Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
