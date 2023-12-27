package com.example.goalsapp.presentation.screens.goals_screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.goalsapp.R
import com.example.goalsapp.presentation.screens.planer_screen.components.DialogConfirmButton
import com.example.goalsapp.presentation.screens.planer_screen.components.FieldsForTaskAdding

@Composable
fun DialogForGoalAdding(showDialog: MutableState<Boolean>) {
    val titleText = remember {
        mutableStateOf("")
    }

    val descriptionText = remember {
        mutableStateOf("")
    }

    val goalText = remember {
        mutableStateOf("")
    }

    val addedValueText = remember {
        mutableStateOf("")
    }

    val selectedItem = rememberSaveable {
        mutableStateOf(0)
    }

    AlertDialog(
        onDismissRequest = {
            showDialog.value = false
        },
        confirmButton = {
            AddButton(
                titleText = titleText,
                descriptionText = descriptionText,
                goalText = goalText,
                addedValueText = addedValueText,
                selectedItem = selectedItem,
                showDialog = showDialog
            )
        },
        title = {
            Text(
                text = stringResource(id = R.string.tittle_add_goal),
                style = MaterialTheme.typography.displayLarge
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                MainTextField(
                    text = titleText,
                    hintTextRes = R.string.title_hint,
                    maxLines = 1
                )

                MainTextField(
                    text = descriptionText,
                    hintTextRes = R.string.text_hint,
                    maxLines = 5
                )

                MainTextField(
                    text = goalText,
                    hintTextRes = R.string.goal_hint,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                MainTextField(
                    text = addedValueText,
                    hintTextRes = R.string.goal_min_value_hint,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                IconsRow(selectedItem = selectedItem)
            }
        },
        shape = RoundedCornerShape(16.dp),
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        textContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
    )
}