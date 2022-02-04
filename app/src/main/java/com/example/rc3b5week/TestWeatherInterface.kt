package com.example.rc3b5week

import com.example.rc3b5week.testModel.TestResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TestWeatherInterface {
    @GET("weather")
    fun getWeather(@Query("p") p : String,
                   @Query("appid") appid : String
    ) : Call<TestResponse>
}