package com.example.goalsapp.presentation.screens.planer_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.goalsapp.R

@Composable
fun PlanerHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 40.dp,
                bottom = 8.dp,
                start = 50.dp,
                end = 8.dp
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.planer_header_text),
            color = MaterialTheme.colorScheme.secondaryContainer,
            style = MaterialTheme.typography.displayLarge
        )

        Text(
            text = stringResource(id = R.string.planer_header_hint_text),
            color = MaterialTheme.colorScheme.secondaryContainer,
            style = MaterialTheme.typography.displayMedium
        )

        Divider(
            modifier = Modifier.fillMaxWidth(.7f),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.secondaryContainer
        )
    }
}