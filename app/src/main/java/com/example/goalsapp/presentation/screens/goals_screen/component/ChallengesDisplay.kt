package com.example.goalsapp.presentation.screens.goals_screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.goalsapp.domain.model.Challenge
import com.example.goalsapp.presentation.screens.goals_screen.viewmodel.ChallengesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChallengesDisplay(
    challengesViewModel: ChallengesViewModel = koinViewModel()
) {

    LaunchedEffect(key1 = Unit) {
        challengesViewModel.getAllChallenges()
    }

    val listOfChallenges = challengesViewModel.listOfChallenges.collectAsState().value

    val showDeleteDialog = remember {
        mutableStateOf(false)
    }

    val challengeToDelete = remember {
        mutableStateOf(
            Challenge(
                title = "",
                text = "",
                iconKey = 0,
                goalValue = 0,
                addingValue = 0,
                progressPercent = 0f
            )
        )
    }

    if (showDeleteDialog.value)
        DeleteDialog(
            showDeleteDialog = showDeleteDialog,
            challenge = challengeToDelete
        )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, start = 10.dp, end = 10.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(
            items = listOfChallenges,
            key = { challenge ->
                challenge.id
            }
        ) { challenge ->

            if (listOfChallenges.last() == challenge) {
                Challenge(
                    challenge = challenge,
                    paddingBottomNeeded = true,
                    showDeleteDialog = showDeleteDialog,
                    challengeToDelete = challengeToDelete
                )
            } else {
                Challenge(
                    challenge = challenge,
                    showDeleteDialog = showDeleteDialog,
                    challengeToDelete = challengeToDelete
                )
            }
        }
    }
}