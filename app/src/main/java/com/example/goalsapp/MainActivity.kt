package com.example.goalsapp

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import com.example.goalsapp.presentation.navigation.Navigation
import com.example.goalsapp.ui.theme.GoalsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoalsAppTheme {
                val context = LocalContext.current as Activity
                context.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

                Navigation()
            }
        }
    }
}