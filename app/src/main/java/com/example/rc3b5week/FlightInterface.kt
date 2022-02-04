package com.example.rc3b5week

import com.example.rc3b5week.flight.FlightList
import com.example.rc3b5week.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightInterface {
    @GET("getFlightOpratInfoList")
    fun getWeather(@Query("serviceKey") serviceKey : String,
                   @Query("numOfRows") numOfRows : Int,
                   @Query("pageNo") lon : Int,
                   @Query("depAirportId") depAirportId : String,
                   @Query("arrAirportId") arrAirportId : String,
                   @Query("depPlandTime") depPlandTime : Int,
                   @Query("airlineId") airlineId : String,
                   @Query("_type") _type: String = "json"

    ) : Call<FlightList>
}