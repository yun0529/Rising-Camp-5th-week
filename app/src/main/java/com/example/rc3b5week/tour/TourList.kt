package com.example.rc3b5week.tour

import com.example.rc3b5week.tour.Item

data class TourList(
    val currentPage: Int,
    val items: List<Item>,
    val pageCount: Int,
    val pageSize: Int,
    val result: String,
    val resultCount: Int,
    val resultMessage: String,
    val totalCount: Int
)