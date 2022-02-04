package com.example.rc3b5week

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TestRetrofitClient {
    val wRetrofit = initRetrofit()
    private const val WEATHER_URL = "https://api.openweathermap.org/data/2.5/"

    private fun initRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(WEATHER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}