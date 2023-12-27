package com.example.goalsapp.presentation.screens.goals_screen.component

import android.widget.Toast
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goalsapp.R
import com.example.goalsapp.presentation.screens.goals_screen.viewmodel.ChallengesViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddButton(
    challengesViewModel: ChallengesViewModel = koinViewModel(),
    titleText: MutableState<String>,
    descriptionText: MutableState<String>,
    goalText: MutableState<String>,
    addedValueText: MutableState<String>,
    selectedItem: MutableState<Int>,
    showDialog: MutableState<Boolean>
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Button(
        onClick = {
            when {
                titleText.value.trim().isEmpty() || descriptionText.value.trim().isEmpty() -> {
                    scope.launch {
                        Toast.makeText(context, context.getString(R.string.snackbar_fields_text), Toast.LENGTH_LONG).show()
                    }
                }

                goalText.value.toIntOrNull() == null || addedValueText.value.toIntOrNull() == null -> {
                    scope.launch {
                        Toast.makeText(context, context.getString(R.string.snackbar_numbers_text), Toast.LENGTH_LONG).show()
                    }
                }

                else -> {
                    challengesViewModel.insertChallengeIntoDatabase(
                        title = titleText.value,
                        text = descriptionText.value,
                        iconKey = selectedItem.value,
                        addingValue = addedValueText.value.toInt(),
                        goalValue = goalText.value.toInt()
                    )
                    showDialog.value = false
                }
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = stringResource(id = R.string.button_add_task_text),
            style = MaterialTheme.typography.displayLarge,
            fontSize = 18.sp
        )
    }
}