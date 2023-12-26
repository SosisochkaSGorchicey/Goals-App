package com.example.goalsapp.presentation.screens.planer_screen.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.goalsapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskWithSwiping(
    task: String
) {
    val listOfGoals = listOf("1", "2")
    val dismissState = rememberDismissState()

    if (dismissState.isDismissed(direction = DismissDirection.EndToStart)) {
        //mainViewModel.removeItemFromDatabase(goal = goal)
    }

    SwipeToDismiss(
        state = dismissState,
        directions = setOf(
            DismissDirection.EndToStart
        ),
        background = {
            val backgroundColor by animateColorAsState(
                when (dismissState.targetValue) {
                    DismissValue.DismissedToStart -> MaterialTheme.colorScheme.primaryContainer
                    else -> MaterialTheme.colorScheme.background
                },
                label = "background"
            )

            val iconScale by animateFloatAsState(
                targetValue = if (dismissState.targetValue == DismissValue.DismissedToStart) 1.3f else 0.0f,
                label = "icon size"
            )

            Box(
                Modifier
                    .then(
                        if (listOfGoals.isNotEmpty() && listOfGoals[0] == task) Modifier.padding(
                            top = 10.dp
                        )
                        else if (listOfGoals.isNotEmpty() && listOfGoals.last() == task) Modifier.padding(
                            bottom = 50.dp
                        )
                        else Modifier.padding(0.dp)
                    )
                    .fillMaxSize()
                    .background(color = backgroundColor, shape = RoundedCornerShape(10.dp))
                    .padding(end = 16.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    modifier = Modifier.scale(iconScale),
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },
        dismissContent = {
            when {
                listOfGoals.isNotEmpty() && listOfGoals[0] == task -> {
                    Task(
                        paddingTopNeeded = true,
                        task = task
                    )
                }

                listOfGoals.isNotEmpty() && listOfGoals.last() == task -> {
                    Task(
                        paddingBottomNeeded = true,
                        task = task
                    )
                }

                else -> Task(task = task)
            }
        }
    )

}