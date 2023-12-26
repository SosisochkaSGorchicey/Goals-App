package com.example.goalsapp.data

import com.example.goalsapp.data.datasource.model.ChallengeEntity
import com.example.goalsapp.domain.model.Challenge


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