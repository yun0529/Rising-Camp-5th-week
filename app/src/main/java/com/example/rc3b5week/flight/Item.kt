package com.example.rc3b5week.flight

data class Item(
    val airlineNm: String,
    val arrAirportNm: String,
    val arrPlandTime: Long,
    val depAirportNm: String,
    val depPlandTime: Long,
    val economyCharge: Int,
    val prestigeCharge: Int,
    val vihicleId: String
)