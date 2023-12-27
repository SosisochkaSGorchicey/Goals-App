package com.example.goalsapp.presentation.screens.goals_screen.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.goalsapp.domain.model.Challenge

@Composable
fun ChallengeDeleteButton(
    challenge: Challenge,
    challengeToDelete: MutableState<Challenge>,
    showDeleteDialog: MutableState<Boolean>
) {
    IconButton(
        onClick = {
            challengeToDelete.value = challenge
            showDeleteDialog.value = true
        }
    ) {
        Icon(
            imageVector = Icons.Outlined.Clear,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}