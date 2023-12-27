package com.example.goalsapp.presentation.screens.planer_screen.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.goalsapp.R

@Composable
fun AddTaskDialog(
    showDialog: MutableState<Boolean>
) {
    val taskText = rememberSaveable {
        mutableStateOf("")
    }

    val chosenColor = remember {
        mutableLongStateOf(0xFFFFFFFF)
    }

    AlertDialog(
        onDismissRequest = {
            showDialog.value = false
        },
        confirmButton = {
            DialogConfirmButton(
                showDialog = showDialog,
                taskText = taskText,
                chosenColor = chosenColor
            )
        },
        title = {
            Text(
                text = stringResource(id = R.string.tittle_add_task),
                style = MaterialTheme.typography.displayLarge
            )
        },
        text = {
            FieldsForTaskAdding(
                taskText = taskText,
                chosenColor = chosenColor
            )
        },
        shape = RoundedCornerShape(16.dp),
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        textContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
    )
}