package com.example.goalsapp.data.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.goalsapp.data.datasource.dao.ChallengeDao
import com.example.goalsapp.data.datasource.dao.TaskDao
import com.example.goalsapp.data.datasource.model.ChallengeEntity
import com.example.goalsapp.data.datasource.model.TaskEntity

@Database(entities = [ChallengeEntity::class, TaskEntity::class], version = 1)
abstract class MainDatabase : RoomDatabase() {
    abstract fun challengeDao(): ChallengeDao

    abstract fun taskDao(): TaskDao
}