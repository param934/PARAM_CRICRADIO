package com.example.cricradio.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cricradio.api.CricViewModel
import com.example.cricradio.websocket.WebSocketScreen

@Composable
fun HomeScreen(viewModel: CricViewModel) {
    val miniScorecard by viewModel.miniScorecard.collectAsState(initial = null)
    val venueInfo by viewModel.venueInfo.collectAsState(initial = null)

    LaunchedEffect("SA_vs_SL_2024-12-05_1732276435.300452") {
        viewModel.fetchMatchDetails("SA_vs_SL_2024-12-05_1732276435.300452")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(start = 4.dp, end = 4.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        miniScorecard?.responseData?.result?.let { matchResult ->
            MiniScorecard(matchResult)
        }
        Spacer(modifier = Modifier.height(20.dp))
        venueInfo?.responseData?.venueResult?.let { venueResult ->
            VenueInfo(venueInfo, startingDate = venueResult.startDate?.formattedDate ?: "Unknown Date")
        }
        Spacer(modifier = Modifier.height(20.dp))
        venueInfo?.responseData?.venueResult?.let {Toss(venueInfo)}
        Spacer(modifier = Modifier.height(20.dp))
        venueInfo?.responseData?.venueResult?.let {Umpires(venueInfo)}
        Spacer(modifier = Modifier.height(20.dp))
        venueInfo?.responseData?.venueResult?.let {Weather(venueInfo)}
        Spacer(modifier = Modifier.height(20.dp))
        venueInfo?.responseData?.venueResult?.let { VenueStats(venueInfo) }
        Spacer(modifier = Modifier.height(60.dp))
        WebSocketScreen()
    }


}


