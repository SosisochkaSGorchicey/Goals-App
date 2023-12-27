package com.example.goalsapp.presentation.screens.goals_screen.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import com.example.goalsapp.R
import com.example.goalsapp.domain.model.Challenge
import com.example.goalsapp.presentation.screens.goals_screen.viewmodel.ChallengesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DeleteDialog(
    showDeleteDialog: MutableState<Boolean>,
    challengesViewModel: ChallengesViewModel = koinViewModel(),
    challenge: MutableState<Challenge>
) {

    AlertDialog(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        iconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        textContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        icon = {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = null
            )
        },
        text = {
            Text(
                text = stringResource(id = R.string.delete_dialog_text),
                style = MaterialTheme.typography.displayMedium
            )
        },
        onDismissRequest = {
            showDeleteDialog.value = false
        },
        confirmButton = {
            Button(
                onClick = {
                    challengesViewModel.removeChallengeFromDatabase(challenge = challenge.value)
                    showDeleteDialog.value = false
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    contentColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Text(
                    text = stringResource(id = R.string.delete_dialog_confirm),
                    style = MaterialTheme.typography.displayMedium
                )
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    showDeleteDialog.value = false
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    contentColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Text(
                    text = stringResource(id = R.string.delete_dialog_dismiss),
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }
    )

}