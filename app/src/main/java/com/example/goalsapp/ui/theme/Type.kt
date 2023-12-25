package com.example.goalsapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = mainFont,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Light
    ),
    displayLarge = TextStyle(
        fontFamily = mainFont,
        fontSize = 28.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.Black
    ),
    titleMedium = TextStyle(
        fontFamily = mainFont,
        fontSize = 18.sp,
        lineHeight = 18.sp
    )
)