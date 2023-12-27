package com.example.goalsapp.presentation.screens.planer_screen.components

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.goalsapp.R
import com.example.goalsapp.domain.model.Task
import com.example.goalsapp.presentation.screens.planer_screen.viewmodel.PlanerViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskWithSwiping(
    task: Task,
    planerViewModel: PlanerViewModel = koinViewModel()
) {
    val listOfTasks = planerViewModel.listOfTasks.collectAsState().value

    val dismissState = rememberDismissState()
    Log.v("alice", dismissState.isDismissed(direction = DismissDirection.EndToStart).toString())
    if (dismissState.isDismissed(direction = DismissDirection.EndToStart)) {
        planerViewModel.deleteTask(task = task)
    }

    SwipeToDismiss(
        state = dismissState,
        directions = setOf(
            DismissDirection.EndToStart
        ),
        background = {
            val backgroundColor by animateColorAsState(
                when (dismissState.targetValue) {
                    DismissValue.DismissedToStart -> MaterialTheme.colorScheme.inverseSurface
                    else -> MaterialTheme.colorScheme.primaryContainer
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
                        if (listOfTasks.isNotEmpty() && listOfTasks.last() == task) Modifier.padding(
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
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        },
        dismissContent = {
            when {
                listOfTasks.isNotEmpty() && listOfTasks.last() == task -> {
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