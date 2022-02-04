package com.example.rc3b5week

import com.example.rc3b5week.flight.FlightList
import com.example.rc3b5week.model.WeatherResponse
import com.example.rc3b5week.tour.TourList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TourInterface {
    @GET("searchList")
    fun getWeather(@Query("apiKey") apiKey : String,
                   @Query("locale") locale : String,
                   @Query("category") category : String,
                   @Query("page") page : Int,
                   @Query("cid") cid : String

    ) : Call<TourList>
}