package com.example.goalsapp.data.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.goalsapp.data.datasource.dao.ChallengeDao
import com.example.goalsapp.data.datasource.model.ChallengeEntity

@Database(entities = [ChallengeEntity::class], version = 1)
abstract class GoalDatabase : RoomDatabase() {
    abstract fun challengeDao(): ChallengeDao
}