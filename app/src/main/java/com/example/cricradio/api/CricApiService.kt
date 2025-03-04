package com.example.cricradio.api

import android.util.Log
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.client.plugins.*
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.CancellationException
import javax.inject.Inject

class CricApiService @Inject constructor(
    private val client: HttpClient
) {
    private val BASE_URL = "http://3.6.243.12:5001"
    private val AUTH_HEADER = "Basic Y3JpY2tldFJhZGlvOmNyaWNrZXRAJCUjUmFkaW8xMjM="

    suspend fun getMiniScorecard(key: String): MatchResponse? {
        Log.d("CricApiService", "Fetching Mini Scorecard for key: $key")

        return try {
            val response: MatchResponse = client.get("$BASE_URL/api/v2/match/mini-match-card") {
                header(HttpHeaders.Authorization, AUTH_HEADER)
                url {
                    parameters.append("key", key)
                }
            }.body()

            Log.d("CricApiService", "Success: Mini Scorecard fetched")
            response
        } catch (e: ClientRequestException) {
            Log.e("CricApiService", "Client error: ${e.response.status}", e)
            null
        } catch (e: ServerResponseException) {
            Log.e("CricApiService", "Server error: ${e.response.status}", e)
            null
        } catch (e: IOException) {
            Log.e("CricApiService", "Network error", e)
            null
        } catch (e: CancellationException) {
            throw e // Don't catch coroutine cancellations
        } catch (e: Exception) {
            Log.e("CricApiService", "Unexpected error", e)
            null
        }
    }

    suspend fun getVenueInfo(key: String): VenueResponse? {
        Log.d("CricApiService", "Fetching Venue Info for key: $key")

        return try {
            val response: VenueResponse = client.get("$BASE_URL/api/v2/match/venue-info") {
                header(HttpHeaders.Authorization, AUTH_HEADER)
                url {
                    parameters.append("key", key)
                }
            }.body()

            Log.d("CricApiService", "Success: Venue Info fetched")
            response
        } catch (e: Exception) {
            Log.e("CricApiService", "Error fetching Venue Info", e)
            null
        }
    }
}
