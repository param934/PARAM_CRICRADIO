package com.example.cricradio.homeScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cricradio.R
import com.example.cricradio.api.MatchResult

@Composable
fun MiniScorecard(scoreDetails: MatchResult) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Score(
                    logo = scoreDetails.teams?.teamA?.logo ?: "",
                    name = scoreDetails.teams?.teamA?.shortName ?: "N/A",
                    runs = scoreDetails.teams?.teamA?.firstInningScoreA?.runs ?: 0,
                    wickets = scoreDetails.teams?.teamA?.firstInningScoreA?.wickets ?: 0,
                    overs = scoreDetails.teams?.teamA?.firstInningScoreA?.overs ?: "0.0",
                    isBatting = scoreDetails.settingObj?.currentTeam == "a"
                )

                Text(
                    text = scoreDetails.lastCommentary?.primaryText ?: "No updates",
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Score(
                    logo = scoreDetails.teams?.teamB?.logo ?: "",
                    name = scoreDetails.teams?.teamB?.shortName ?: "N/A",
                    runs = scoreDetails.teams?.teamB?.firstInningScoreB?.runs ?: 0,
                    wickets = scoreDetails.teams?.teamB?.firstInningScoreB?.wickets ?: 0,
                    overs = scoreDetails.teams?.teamB?.firstInningScoreB?.overs ?: "0.0",
                    isBatting = scoreDetails.settingObj?.currentTeam == "b"
                )
            }

            HorizontalDivider(modifier = Modifier.padding(top=4.dp, bottom = 8.dp), color = Color(0xFF224976))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    RunRateLabel("CRR: ", scoreDetails.now?.runRate ?: "N/A")

                    if (!scoreDetails.now?.requiredRunRate.isNullOrEmpty()) {
                        RunRateLabel("RRR: ", scoreDetails.now?.requiredRunRate ?: "N/A")
                    }
                }

                Text(
                    text = scoreDetails.announcement1 ?: "",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}

@Composable
fun Score(
    logo: String,
    name: String,
    runs: Int,
    wickets: Int,
    overs: String,
    isBatting: Boolean
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            AsyncImage(
                model = logo,
                contentDescription = "Team Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
            )
            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.primary
            )
            if (isBatting) {
                Icon(
                    painter = painterResource(R.drawable.bat),
                    contentDescription = "Batting Icon",
                    tint = MaterialTheme.colorScheme.onTertiaryContainer,
                )
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "$runs/$wickets",
            fontSize = if (isBatting) 20.sp else 18.sp,
            fontWeight = if(isBatting) FontWeight.Bold else FontWeight.Medium,
            color = if (isBatting) MaterialTheme.colorScheme.onTertiaryContainer else MaterialTheme.colorScheme.secondary
        )

        Text(
            text = overs,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun RunRateLabel(label: String, value: String) {
    Text(
        text = buildAnnotatedString {
            append(label)
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.tertiary, fontWeight = FontWeight.Medium)) {
                append(value)
            }
        },
        fontSize = 14.sp,
        color = MaterialTheme.colorScheme.primary
    )
}
