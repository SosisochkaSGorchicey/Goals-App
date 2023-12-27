package com.example.goalsapp.presentation.screens.planer_screen.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.goalsapp.R
import com.example.goalsapp.domain.model.Task
import com.example.goalsapp.presentation.screens.planer_screen.viewmodel.PlanerViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun Task(
    paddingBottomNeeded: Boolean = false,
    task: Task,
    planerViewModel: PlanerViewModel = koinViewModel()
) {
    val scale = remember {
        Animatable(1f)
    }

    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .then(
                if (paddingBottomNeeded) Modifier.padding(bottom = 50.dp)
                else Modifier.padding(0.dp)
            )
            .scale(scale = scale.value)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = if (task.colorPosition < taskColors.size)
                    Color(taskColors[task.colorPosition])
                else MaterialTheme.colorScheme.tertiaryContainer,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                if (!task.isDone) {
                    coroutineScope.launch {
                        scale.animateTo(
                            1.1f,
                            animationSpec = tween(300),
                        )
                        scale.animateTo(
                            1f,
                            animationSpec = tween(150),
                        )
                    }
                }

                planerViewModel.updateTask(task = task.copy(isDone = !task.isDone))
                planerViewModel.getAllTasks()
            }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .weight(1f),
            text = task.text,
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.secondaryContainer
        )


        Icon(
            modifier = Modifier.size(20.dp),
            imageVector = Icons.Filled.Check,
            contentDescription = null,
            tint = if (task.isDone) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent
        )
    }

}