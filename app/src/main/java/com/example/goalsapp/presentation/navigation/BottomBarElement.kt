package com.example.goalsapp.presentation.navigation

import com.example.goalsapp.R


sealed class BottomBarElement(val route: String, val iconRes: Int, val textRes: Int) {
    object Goals : BottomBarElement(
        route = "goals",
        iconRes = R.drawable.goal,
        textRes = R.string.label_goals_text
    )

    object Planer : BottomBarElement(
        route = "planer",
        iconRes = R.drawable.planer,
        textRes = R.string.label_planer_text
    )
}

val navItems = listOf(
    BottomBarElement.Goals,
    BottomBarElement.Planer
)
