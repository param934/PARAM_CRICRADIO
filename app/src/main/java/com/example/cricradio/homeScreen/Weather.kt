package com.example.cricradio.homeScreen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cricradio.R
import com.example.cricradio.api.VenueResponse
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun Weather(venueResponse: VenueResponse?) {
    val venueWeather = venueResponse?.responseData?.venueResult?.weather ?: return
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH)
    val outputFormatter = DateTimeFormatter.ofPattern("dd MMM, hh:mm a", Locale.ENGLISH)

    val dateTimeText = venueWeather.lastUpdated
    val dateTime = try {
        dateTimeText?.let {
            LocalDateTime.parse(it, inputFormatter)
        }
    } catch (e: Exception) {
        null
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(text = "Weather", color = MaterialTheme.colorScheme.primary, fontSize = 13.sp)
    }
    Spacer(Modifier.height(8.dp))
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.outline)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = "https://cricradio-backend.s3.ap-south-1.amazonaws.com/cricradio_weather_icons/Frame+2608896.png",
                contentDescription = "weather_icon",
                modifier = Modifier
                    .size(100.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))
            Column {
                venueWeather.location?.let {
                    Text(it, color = Color(0xFFa5a5a5), fontSize = 14.sp)
                }

                Text(
                    text = "${venueWeather.temperature ?: "--"} \u00B0 C",
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Normal
                )
                venueWeather.condition?.text?.let {
                    Text(it, color = Color(0xFF6eaefa), fontSize = 16.sp, fontWeight = FontWeight.Medium)
                }
            }
            VerticalDivider(
                modifier = Modifier
                    .height(90.dp)
                    .padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.outline
            )
            Column(horizontalAlignment = Alignment.Start) {
                Text("Last Updated", color = MaterialTheme.colorScheme.onSecondaryContainer, fontSize = 14.sp)
                Text(
                    text = dateTime?.format(outputFormatter) ?: "Invalid Date",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 13.sp
                )
            }
        }
    }
}
