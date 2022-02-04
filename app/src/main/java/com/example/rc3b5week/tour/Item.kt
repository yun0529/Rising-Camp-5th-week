package com.example.rc3b5week.tour

import com.example.rc3b5week.tour.Contentscd
import com.example.rc3b5week.tour.Region1cd
import com.example.rc3b5week.tour.Region2cd
import com.example.rc3b5week.tour.RepPhoto

data class Item(
    val address: String,
    val alltag: String,
    val contentscd: Contentscd,
    val contentsid: String,
    val introduction: String,
    val latitude: Double,
    val longitude: Double,
    val phoneno: String,
    val postcode: String,
    val region1cd: Region1cd,
    val region2cd: Region2cd,
    val repPhoto: RepPhoto,
    val roadaddress: String,
    val tag: String,
    val title: String
)