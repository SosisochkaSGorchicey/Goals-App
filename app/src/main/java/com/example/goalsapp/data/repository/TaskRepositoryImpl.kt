package com.example.goalsapp.data.repository

import com.example.goalsapp.data.datasource.dao.TaskDao
import com.example.goalsapp.data.fromDomain
import com.example.goalsapp.data.toDomain
import com.example.goalsapp.domain.model.Task
import com.example.goalsapp.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {

    override fun getAllTasks(): Flow<List<Task>> {
        val allTasksFlow = taskDao.getAllTasks()

        val result: Flow<List<Task>> =
            allTasksFlow.map { list ->
                list.map { taskEntity ->
                    taskEntity.toDomain()
                }
            }

        return result
    }

    override suspend fun insertTaskIntoDatabase(task: Task) {
        taskDao.insertTaskIntoDatabase(taskEntity = task.fromDomain())
    }

    override suspend fun updateTask(task: Task) {
        taskDao.updateTask(taskEntity = task.fromDomain())
    }

    override suspend fun removeTaskFromDatabase(task: Task) {
        taskDao.removeTaskFromDatabase(taskEntity = task.fromDomain())
    }

}