package com.example.goalsapp.domain.repository

import com.example.goalsapp.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTasks(): Flow<List<Task>>

    suspend fun insertTaskIntoDatabase(task: Task)

    suspend fun updateTask(task: Task)

    suspend fun removeTaskFromDatabase(task: Task)
}