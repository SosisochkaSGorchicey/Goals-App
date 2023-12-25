package com.example.goalsapp.presentation.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.goalsapp.presentation.goals_screen.GoalsScreen
import com.example.goalsapp.presentation.planer_screen.PlanerScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = BottomBarElement.Goals.route
    ) {
        composable(BottomBarElement.Goals.route) {
            Scaffold(
                bottomBar = {
                    BottomBar(navController = navController)
                }
            ) { innerPadding ->
                GoalsScreen(
                    innerPadding = innerPadding
                )
            }
        }

        composable(BottomBarElement.Planer.route) {
            Scaffold(
                bottomBar = {
                    BottomBar(navController = navController)
                }
            ) { innerPadding ->
                PlanerScreen(
                    innerPadding = innerPadding
                )
            }
        }
    }
}