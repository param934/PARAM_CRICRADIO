package com.example.cricradio.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cricradio.api.VenueResponse

@Composable
fun VenueInfo(venueResponse: VenueResponse?, startingDate: String) {
    val venueResult = venueResponse?.responseData?.venueResult
    val venueDetails = venueResult?.venueDetails

    Column {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = venueDetails?.photo ?: "",
                contentDescription = "Venue Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(180.dp)
            )
        }
        Text(
            text = "${venueDetails?.venueScraptitle ?: "Unknown Venue"}, ${venueDetails?.venueLocation ?: ""}",
            color = MaterialTheme.colorScheme.tertiary,
            fontSize = 15.sp,
            modifier = Modifier.padding(top=8.dp),
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "${venueResult?.relatedName ?: ""} ${venueResult?.season?.name ?: ""}",
            color = Color.LightGray,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(
            text = startingDate,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 14.sp)
    }
}
