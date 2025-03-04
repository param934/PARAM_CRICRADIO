package com.example.cricradio.api

import javax.inject.Inject

class CricRepository @Inject constructor(
    private val apiService: CricApiService)
{
    suspend fun getMiniScorecard(key: String) = apiService.getMiniScorecard(key = key)
    suspend fun getVenueInfo(key: String) = apiService.getVenueInfo(key = key)
}
