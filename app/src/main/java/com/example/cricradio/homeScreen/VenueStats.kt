package com.example.cricradio.homeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Divider
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//

//@Composable
//fun VenueStats(venueCardResult: VenueCardResult) {
//    Text("Venue Stats", color = Color.White)
//    Spacer(modifier = Modifier.height(8.dp))
//    Card(
//        modifier = Modifier.fillMaxWidth(),
//        colors = CardDefaults.cardColors(containerColor = Color.Black),
//        border = BorderStroke(1.dp, Color.DarkGray)
//    ) {
//        Column(modifier = Modifier.padding(vertical = 8.dp)) {
//            Stats("Matches Played", venueCardResult.venueStats.matchesPlayed.toString())
//            Stats("Lowest Defended", venueCardResult.venueStats.lowestDefended.toString())
//            Stats("Highest Chased", venueCardResult.venueStats.highestChased.toString())
//            Stats("Win Bat First", venueCardResult.venueStats.batFirstWins.toString())
//            Stats("Win Bowl First", venueCardResult.venueStats.ballFirstWins.toString())
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(CardGray)
//                    .padding(vertical = 8.dp, horizontal = 16.dp),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Column(modifier = Modifier.weight(5f)) {
//                    Text("", color = Color.White, fontSize = 14.sp)
//
//                }
//                Column(modifier = Modifier.weight(2f)) {
//                    Text("1st Inn", color = Color.White, fontSize = 11.sp)
//                }
//                Column(modifier = Modifier.weight(1f)) {
//                    Text("2nd Inn", color = Color.White, fontSize = 11.sp)
//
//                }
//            }
//
//            InningStat("Avg Score", venueCardResult.venueStats.battingFirst.averageScore.toString(), venueCardResult.venueStats.battingSecond.averageScore.toString())
//            InningStat("Highest Score", venueCardResult.venueStats.battingFirst.highestScore.toString(), venueCardResult.venueStats.battingSecond.averageScore.toString())
//            InningStat("Lowest Score", venueCardResult.venueStats.battingFirst.lowestScore.toString(), venueCardResult.venueStats.battingSecond.averageScore.toString())
//            InningStat("Pace Wickets", venueCardResult.venueStats.battingFirst.paceWickets.toString(), venueCardResult.venueStats.battingSecond.averageScore.toString())
//            InningStat("Spin Wickets", venueCardResult.venueStats.battingFirst.spinWickets.toString(), venueCardResult.venueStats.battingSecond.averageScore.toString())
//        }
//    }
//}
//
//@Composable
//fun Stats(label: String, value: String) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp, horizontal = 16.dp),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Column(modifier = Modifier.weight(7f)){
//            Text(label, color = Color.White, fontSize = 14.sp)
//        }
//        Column(modifier = Modifier.weight(1f)){
//            Text(value, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
//        }
//    }
//    Divider(color = Color.DarkGray)
//}
//
//@Composable
//fun InningStat(label: String, Inn1: String, Inn2: String) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp, horizontal = 16.dp),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Column(modifier = Modifier.weight(5f)) {
//            Text(label, color = Color.White, fontSize = 14.sp)
//
//        }
//        Column(modifier = Modifier.weight(2f)) {
//            Text(Inn1, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
//        }
//        Column(modifier = Modifier.weight(1f)) {
//            Text(Inn2, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
//
//        }
//    }
//    HorizontalDivider(color = Color.DarkGray)
//}

