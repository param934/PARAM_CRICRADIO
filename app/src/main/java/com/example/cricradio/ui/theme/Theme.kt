package com.example.cricradio.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary=  Color(0xFFdee1e5),
    secondary = Color(0xFF99a4af),
    tertiary =  Color(0xFF8bbefb),
    background = Color.Black,
    primaryContainer =  Color(0xFF001C38),
    onSecondaryContainer = Color(0xFF737373),
    secondaryContainer = Color(0xff1e1e1e),
    onTertiaryContainer = Color(0xFFebbc67),
    tertiaryContainer = Color(0xFF141414),
    outline = Color(0xFF43474e)

)

@Composable
fun CricRadioTheme(
    content: @Composable () -> Unit
) {MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}