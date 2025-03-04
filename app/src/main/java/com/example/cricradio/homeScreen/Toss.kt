package com.example.cricradio.homeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cricradio.api.VenueResponse

@Composable
fun Toss(venueResponse: VenueResponse?) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.outline)
    ) {
        val winningTeam = if (venueResponse?.responseData?.venueResult?.toss?.won == "a") venueResponse.responseData.venueResult.teams?.teamA else venueResponse?.responseData?.venueResult?.teams?.teamA
        if (winningTeam != null) {
            if (venueResponse != null) {
                Text(
                    text = "${winningTeam.shortName} won the toss and chose to ${venueResponse.responseData?.venueResult?.toss?.decision} first",
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}