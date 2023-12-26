package com.example.goalsapp.presentation.screens.planer_screen.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goalsapp.R

@Composable
fun Task(
    paddingTopNeeded: Boolean = false,
    paddingBottomNeeded: Boolean = false,
    task: String
) {

    val scale = remember {
        Animatable(1f)
    }

    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .then(
                if (paddingTopNeeded) Modifier.padding(top = 10.dp)
                else if (paddingBottomNeeded) Modifier.padding(bottom = 50.dp)
                else Modifier.padding(0.dp)
            )
            .scale(scale = scale.value)
            .fillMaxWidth()
//            .border(
//                width = 1.dp,
//                color = if (!task.isDone) MaterialTheme.colorScheme.secondary
//                else MaterialTheme.colorScheme.outline,
//                shape = RoundedCornerShape(10.dp)
//            )
            .clickable {
//                if (!goal.isDone) {
//                    coroutineScope.launch {
//                        scale.animateTo(
//                            1.1f,
//                            animationSpec = tween(300),
//                        )
//                        scale.animateTo(
//                            1f,
//                            animationSpec = tween(150),
//                        )
//                    }
//                }

//                mainViewModel.updateGoal(goal = goal.copy(isDone = !goal.isDone))
//                mainViewModel.getAllGoals()
            }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

//            iconsInfo.get(key = goal.iconKey)?.let {
//                Icon(
//                    modifier = Modifier.size(30.dp),
//                    imageVector = ImageVector.vectorResource(id = it),
//                    contentDescription = stringResource(id = R.string.goal_icon_desc),
//                    tint = MaterialTheme.colorScheme.secondary
//                )
//            }

//            Column() {
//                MainText(
//                    text = goal.title,
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Normal,
//                    textAlign = TextAlign.Start,
//                    color = MaterialTheme.colorScheme.secondary
//                )
//
//                MainText(
//                    text = goal.text,
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Light,
//                    textAlign = TextAlign.Start,
//                    color = MaterialTheme.colorScheme.secondary
//                )
//            }

        }

//        if (goal.isDone) {
//            Icon(
//                modifier = Modifier.size(20.dp),
//                imageVector = Icons.Filled.Check,
//                contentDescription = stringResource(id = R.string.done_icon_desc),
//                tint = MaterialTheme.colorScheme.outline
//            )
//        }

    }

}