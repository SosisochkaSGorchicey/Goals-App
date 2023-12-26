package com.example.goalsapp.domain.model

data class Challenge(
    val id: Int = 0,
    val title: String,
    val text: String,
    val iconKey: Int,
    val goalValue: Int,
    val addingValue: Int,
    val progressPercent: Float = .0f
)
