package com.example.goalsapp.presentation.screens.planer_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableLongState
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorsDisplay(chosenColor: MutableLongState) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(taskColors) { taskColor ->
            Card(
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        chosenColor.longValue = taskColor
                    },
                colors = CardDefaults.cardColors(containerColor = Color(taskColor)),
                shape = RoundedCornerShape(6.dp),
                border = if (chosenColor.longValue == taskColor) BorderStroke(
                    width = 3.dp,
                    color = MaterialTheme.colorScheme.inverseSurface
                )
                else null
            ) {}
        }
    }
}