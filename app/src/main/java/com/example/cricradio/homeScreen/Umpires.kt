package com.example.cricradio.homeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cricradio.api.VenueResponse

@Composable
fun Umpires(venueResponse: VenueResponse?) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(text = "Umpires", color = MaterialTheme.colorScheme.primary, fontSize = 13.sp)
    }
    Spacer(Modifier.height(8.dp))

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.outline)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            venueResponse?.responseData?.venueResult.let {
                if (it != null) {
                    UmpireSection(
                        listOf(
                            "Umpire" to it.firstUmpire,
                            "Umpire" to it.secondUmpire
                        )
                    )
                }

                HorizontalDivider(modifier = Modifier.padding(vertical = 10.dp), color = MaterialTheme.colorScheme.outline)

                if (it != null) {
                    UmpireSection(
                        listOf(
                            "Third/TV Umpire" to it.thirdUmpire,
                            "Referee" to it.matchReferee
                        )
                    )
                }

            }
        }
    }
}

@Composable
fun UmpireSection(umpires: List<Pair<String, String?>>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        umpires.forEach { (title, name) ->
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = MaterialTheme.colorScheme.onSecondaryContainer, fontSize = 12.sp)
                name?.let { Text(it, color = MaterialTheme.colorScheme.primary, fontSize = 14.sp) }
            }
        }
    }
}
