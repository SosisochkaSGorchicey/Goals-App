package com.example.goalsapp.presentation.screens.planer_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.goalsapp.presentation.components.FloatingButton
import com.example.goalsapp.presentation.screens.planer_screen.components.PlanerHeader
import com.example.goalsapp.presentation.screens.planer_screen.components.TaskWithSwiping

@Composable
fun PlanerScreen(
    innerPadding: PaddingValues
) {

    val listOfTasks = listOf("1", "2")

    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.colorScheme.secondaryContainer
                    )
                )
            )
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 100.dp,
                        topEnd = 0.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
                .background(MaterialTheme.colorScheme.onPrimaryContainer),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                PlanerHeader()
            }

            items(listOfTasks) { task ->
                TaskWithSwiping(task = task)
            }
        }

        FloatingButton(action = ::test)
    }
}

fun test() {}