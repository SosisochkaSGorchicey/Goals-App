package com.example.goalsapp.domain.repository

import com.example.goalsapp.domain.model.Challenge
import kotlinx.coroutines.flow.Flow

interface ChallengeRepository {
    fun getAllChallenges(): Flow<List<Challenge>>

    suspend fun insertChallengeIntoDatabase(challenge: Challenge)

    suspend fun updateChallenge(challenge: Challenge)

    suspend fun removeChallengeFromDatabase(challenge: Challenge)
}