package com.example.goalsapp.presentation.screens.goals_screen.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.goalsapp.domain.model.Challenge

@Composable
fun Challenge(
    paddingBottomNeeded: Boolean = false,
    challenge: Challenge,
    showDeleteDialog: MutableState<Boolean>,
    challengeToDelete: MutableState<Challenge>
) {
    Row(
        modifier = Modifier
            .then(
                if (paddingBottomNeeded) Modifier.padding(bottom = 50.dp)
                else Modifier.padding(0.dp)
            )
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                shape = RoundedCornerShape(20.dp)
            )

            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ChallengeProgressWithIcon(challenge = challenge)

            ChallengeText(challenge = challenge)
        }

        ChallengeDeleteButton(
            challenge = challenge,
            challengeToDelete = challengeToDelete,
            showDeleteDialog = showDeleteDialog
        )
    }
}