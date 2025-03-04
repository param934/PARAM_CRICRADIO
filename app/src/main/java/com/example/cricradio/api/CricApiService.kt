package com.example.cricradio.Api

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CricketApiService {
    @GET("/api/v2/match/mini-match-card")
    suspend fun getMiniScorecard(
        @Header("Authorization") auth: String = "Basic Y3JpY2tldFJhZGlvOmNyaWNrZXRAJCUjUmFkaW8xMjM=",
        @Query("key") key: String
    ): MiniScorecardResponse

    @GET("/api/v2/match/venue-info")
    suspend fun getVenueInfo(
        @Header("Authorization") auth: String = "Basic Y3JpY2tldFJhZGlvOmNyaWNrZXRAJCUjUmFkaW8xMjM=",
        @Query("key") key: String
    ): VenueInfoResponse
}
