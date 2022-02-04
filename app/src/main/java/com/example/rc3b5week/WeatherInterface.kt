package com.example.rc3b5week

import com.example.rc3b5week.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInterface {
    @GET("onecall")
    fun getWeather(@Query("lat") lat : Double,
                   @Query("lon") lon : Double,
                   @Query("exclude") exclude : String,
                   @Query("appid") appid : String
    ) : Call<WeatherResponse>
}