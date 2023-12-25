package com.example.goalsapp.presentation.screens.goals_screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.goalsapp.R

@Composable
fun GoalsHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 25.dp,
                bottom = 8.dp,
                start = 50.dp,
                end = 50.dp
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.goals_header_text),
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center
        )

        Divider(
            modifier = Modifier.fillMaxWidth(.5f),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.tertiaryContainer
        )
    }
}