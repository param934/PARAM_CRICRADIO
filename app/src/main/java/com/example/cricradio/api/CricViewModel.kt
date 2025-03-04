package com.example.cricradio.api

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CricViewModel @Inject constructor(
    private val repository: CricRepository
) : ViewModel() {

    private val _miniScorecard = MutableStateFlow<MatchResponse?>(null)
    val miniScorecard: StateFlow<MatchResponse?> = _miniScorecard

    private val _venueInfo = MutableStateFlow<VenueResponse?>(null)
    val venueInfo: StateFlow<VenueResponse?> = _venueInfo

    fun fetchMatchDetails(key: String) {
        viewModelScope.launch {
            Log.d("CricViewModel", "Fetching match details for key: $key")

            val scorecardResponse = repository.getMiniScorecard(key)
            if (scorecardResponse == null) {
                Log.e("CricViewModel", "Mini Scorecard response is null")
            } else {
                Log.d("CricViewModel", "Mini Scorecard received")
                _miniScorecard.update { scorecardResponse }
            }

            val venueResponse = repository.getVenueInfo(key)
            if (venueResponse == null) {
                Log.e("CricViewModel", "Venue Info response is null")
            } else {
                Log.d("CricViewModel", "Venue Info received")
                _venueInfo.update { venueResponse }
            }
        }
    }
}
