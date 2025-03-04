package com.example.cricradio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cricradio.homeScreen.HomeScreen
import com.example.cricradio.ui.theme.CricRadioTheme
import dagger.hilt.android.AndroidEntryPoint


import android.app.Application
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cricradio.api.CricViewModel
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: CricViewModel = hiltViewModel()
            CricRadioTheme {
                HomeScreen(viewModel)
                }
            }
        }
    }

@HiltAndroidApp
class MyApp: Application()