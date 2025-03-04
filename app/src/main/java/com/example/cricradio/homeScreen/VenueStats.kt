package com.example.cricradio.homeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cricradio.api.VenueResponse

@Composable
fun VenueStats(venueResponse: VenueResponse?) {
    val venueStats = venueResponse?.responseData?.venueResult?.venueStats ?: return
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(text = "Venue Stats", color = MaterialTheme.colorScheme.primary, fontSize = 13.sp)
    }
    Spacer(modifier = Modifier.height(8.dp))
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            Stats("Matches Played", venueStats.matchesPlayed.toString())
            Stats("Lowest Defended", venueStats.lowestDefended.toString())
            Stats("Highest Chased", venueStats.highestChased.toString())
            Stats("Win Bat First", venueStats.batFirstWins.toString())
            Stats("Win Bowl First", venueStats.ballFirstWins.toString())
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF121212))
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(5f)) {
                    Text("", fontSize = 14.sp)

                }
                Column(modifier = Modifier.weight(2f)) {
                    Text("1st Inn", color = Color(0xFF6c6c6c), fontSize = 12.sp)
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("2nd Inn", color = Color(0xFF6c6c6c), fontSize = 12.sp)

                }
            }
            InningStat("Avg Score", venueStats.battingFirst?.averageScore.toString(), venueStats.battingSecond?.averageScore.toString())
            InningStat("Highest Score", venueStats.battingFirst?.highestScore.toString(), venueStats.battingSecond?.averageScore.toString())
            InningStat("Lowest Score", venueStats.battingFirst?.lowestScore.toString(), venueStats.battingSecond?.averageScore.toString())
            InningStat("Pace Wickets", venueStats.battingFirst?.paceWickets.toString(), venueStats.battingSecond?.averageScore.toString())
            InningStat("Spin Wickets", venueStats.battingFirst?.spinWickets.toString(), venueStats.battingSecond?.averageScore.toString())
        }
    }
}

@Composable
fun Stats(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(7f)){
            Text(label, color = Color(0xFF999999) ,fontSize = 12.sp)
        }
        Column(modifier = Modifier.weight(1f)){
            Text(value, color = MaterialTheme.colorScheme.primary, fontSize = 14.sp, fontWeight = FontWeight.Normal)
        }
    }
    HorizontalDivider(
        color = Color(0xFF1f1f1f),
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 16.dp))
}

@Composable
fun InningStat(label: String, Inn1: String, Inn2: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(5f)) {
            Text(label, color = Color(0xFF999999), fontSize = 12.sp)

        }
        Column(modifier = Modifier.weight(2f),
                horizontalAlignment = Alignment.Start){
            Text(Inn1, color = MaterialTheme.colorScheme.primary, fontSize = 14.sp, fontWeight = FontWeight.Normal)
        }
        Column(modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start){
            Text(Inn2, color = MaterialTheme.colorScheme.primary, fontSize = 14.sp, fontWeight = FontWeight.Normal)
        }
    }
    HorizontalDivider(
        color = Color(0xFF1f1f1f),
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 16.dp))
}

