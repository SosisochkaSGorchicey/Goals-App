package com.example.goalsapp.domain.model

data class Task(
    val id: Int = 0,
    val text: String,
    val colorPosition: Int,
    val isDone: Boolean = false
)