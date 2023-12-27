package com.example.goalsapp.data

import com.example.goalsapp.data.datasource.model.ChallengeEntity
import com.example.goalsapp.data.datasource.model.TaskEntity
import com.example.goalsapp.domain.model.Challenge
import com.example.goalsapp.domain.model.Task


fun Challenge.fromDomain(): ChallengeEntity {
    return ChallengeEntity(
        id = id,
        title = title,
        text = text,
        iconKey = iconKey,
        goalValue = goalValue,
        addingValue = addingValue,
        progressPercent = progressPercent
    )
}

fun ChallengeEntity.toDomain(): Challenge {
    return Challenge(
        id = id,
        title = title,
        text = text,
        iconKey = iconKey,
        goalValue = goalValue,
        addingValue = addingValue,
        progressPercent = progressPercent
    )
}

fun Task.fromDomain(): TaskEntity {
    return TaskEntity(
        id = id,
        text = text,
        colorPosition = colorPosition,
        isDone = isDone
    )
}

fun TaskEntity.toDomain(): Task {
    return Task(
        id = id,
        text = text,
        colorPosition = colorPosition,
        isDone = isDone
    )
}