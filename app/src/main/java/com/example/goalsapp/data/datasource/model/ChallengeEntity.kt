package com.example.goalsapp.data.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "challenges")
data class ChallengeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,

    val text: String,

    val iconKey: Int,

    val goalValue: Int,

    val addingValue: Int,

    val progressPercent: Float = .0f
)
