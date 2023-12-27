package com.example.goalsapp.presentation.screens.goals_screen.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.goalsapp.domain.model.Challenge
import com.example.goalsapp.presentation.screens.goals_screen.viewmodel.ChallengesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChallengeProgressWithIcon(
    challenge: Challenge,
    challengesViewModel: ChallengesViewModel = koinViewModel()
) {
    Box(
        modifier = Modifier
            .clickable {
                if (challenge.progressPercent < 1.0f) {
                    challengesViewModel.updateChallenge(
                        challenge = challenge.copy(
                            progressPercent = challenge.progressPercent + challenge.addingValue.toFloat() / challenge.goalValue.toFloat()
                        )
                    )
                }
            },
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(60.dp),
            strokeWidth = 6.dp,
            progress = challenge.progressPercent,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            backgroundColor = MaterialTheme.colorScheme.primaryContainer
        )

        iconsInfo.get(key = challenge.iconKey)?.let {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = ImageVector.vectorResource(id = it),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}