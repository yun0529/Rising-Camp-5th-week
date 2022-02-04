package com.example.rc3b5week.model

import com.example.rc3b5week.model.Current
import com.example.rc3b5week.model.Daily
import com.example.rc3b5week.model.Hourly
import com.example.rc3b5week.model.Minutely

data class WeatherResponse(
    val current: Current,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Double,
    val lon: Double,
    val minutely: List<Minutely>,
    val timezone: String,
    val timezone_offset: Int
)