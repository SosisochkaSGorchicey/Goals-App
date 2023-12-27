package com.example.goalsapp.presentation.screens.goals_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.goalsapp.presentation.components.FloatingButton
import com.example.goalsapp.presentation.screens.goals_screen.component.ChallengesDisplay
import com.example.goalsapp.presentation.screens.goals_screen.component.DialogForGoalAdding
import com.example.goalsapp.presentation.screens.goals_screen.component.GoalsHeader

@Composable
fun GoalsScreen(
    innerPadding: PaddingValues
) {
    val showDialog = remember {
        mutableStateOf(false)
    }
    if (showDialog.value) DialogForGoalAdding(showDialog = showDialog)

    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.colorScheme.tertiaryContainer
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 80.dp,
                        topEnd = 80.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
                .background(MaterialTheme.colorScheme.secondaryContainer),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GoalsHeader()

            ChallengesDisplay()
        }

        FloatingButton(showDialog = showDialog)
    }
}