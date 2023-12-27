package com.example.goalsapp.presentation.screens.planer_screen.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableLongState
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goalsapp.R
import com.example.goalsapp.presentation.screens.planer_screen.viewmodel.PlanerViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DialogConfirmButton(
    showDialog: MutableState<Boolean>,
    chosenColor: MutableLongState,
    taskText: MutableState<String>,
    planerViewModel: PlanerViewModel = koinViewModel()
) {
    Button(
        onClick = {
            planerViewModel.saveTask(
                text = taskText.value,
                colorPosition = taskColors.indexOf(chosenColor.longValue)
            )

            showDialog.value = false
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
            contentColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.button_add_task_text),
            style = MaterialTheme.typography.displayLarge,
            fontSize = 16.sp
        )
    }
}