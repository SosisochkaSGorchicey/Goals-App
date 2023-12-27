package com.example.goalsapp.presentation.screens.goals_screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.goalsapp.R
import com.example.goalsapp.domain.model.Challenge

@Composable
fun ChallengeText(
    challenge: Challenge
) {
    Column {
        Text(
            text = challenge.title,
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )

        Text(
            text = challenge.text,
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )

        Text(
            text = stringResource(
                id = R.string.challenge_goal_and_value,
                challenge.goalValue,
                challenge.addingValue
            ),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}