package com.example.goalsapp.data.datasource.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.goalsapp.data.datasource.model.ChallengeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChallengeDao {
    @Query("SELECT * FROM challenges")
    fun getAllChallenges(): Flow<List<ChallengeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChallengeIntoDatabase(challengeEntity: ChallengeEntity)

    @Update
    suspend fun updateChallenge(challengeEntity: ChallengeEntity)

    @Delete
    suspend fun removeChallengeFromDatabase(challengeEntity: ChallengeEntity)
}