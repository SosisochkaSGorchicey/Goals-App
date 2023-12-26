package com.example.goalsapp.data.repository

import com.example.goalsapp.data.datasource.dao.ChallengeDao
import com.example.goalsapp.data.fromDomain
import com.example.goalsapp.data.toDomain
import com.example.goalsapp.domain.model.Challenge
import com.example.goalsapp.domain.repository.ChallengeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChallengeRepositoryImpl(
    private val dao: ChallengeDao
) : ChallengeRepository {
    override fun getAllChallenges(): Flow<List<Challenge>> {
        val allChallengesFlow = dao.getAllChallenges()

        val result: Flow<List<Challenge>> =
            allChallengesFlow.map { list ->
                list.map { challengeEntity ->
                    challengeEntity.toDomain()
                }
            }

        return result
    }

    override suspend fun insertChallengeIntoDatabase(challenge: Challenge) {
        dao.insertChallengeIntoDatabase(challengeEntity = challenge.fromDomain())
    }

    override suspend fun updateChallenge(challenge: Challenge) {
        dao.updateChallenge(challengeEntity = challenge.fromDomain())
    }

    override suspend fun removeChallengeFromDatabase(challenge: Challenge) {
        dao.removeChallengeFromDatabase(challengeEntity = challenge.fromDomain())
    }
}