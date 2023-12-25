package com.example.goalsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.goalsapp.presentation.navigation.Navigation
import com.example.goalsapp.ui.theme.GoalsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoalsAppTheme {
                Navigation()
            }
        }
    }
}