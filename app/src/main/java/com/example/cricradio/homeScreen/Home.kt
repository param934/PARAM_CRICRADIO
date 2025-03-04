package com.example.cricradio

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(viewModel: CricketViewModel = hiltViewModel()) {
    val matchKey = "SA_vs_SL_2024-12-05_1732276435.300452"
    val miniScorecard by viewModel.miniScorecard.collectAsState()
    val venueInfo by viewModel.venueInfo.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchMatchDetails(matchKey)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Match: ${miniScorecard?.matchTitle ?: "Loading..."}", style = MaterialTheme.typography.h6)
        Text(text = "Score: ${miniScorecard?.score ?: "Loading..."}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Venue: ${venueInfo?.venueName ?: "Loading..."}", style = MaterialTheme.typography.h6)
        Text(text = "Location: ${venueInfo?.location ?: "Loading..."}")
    }
}

