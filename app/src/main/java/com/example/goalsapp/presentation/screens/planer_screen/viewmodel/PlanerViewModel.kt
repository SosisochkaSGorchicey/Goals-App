package com.example.goalsapp.presentation.screens.planer_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goalsapp.domain.model.Task
import com.example.goalsapp.domain.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class PlanerViewModel(
    private val taskRepository: TaskRepository
) : ViewModel() {

    private val _listOfTasks = MutableStateFlow(listOf<Task>())
    val listOfTasks = _listOfTasks.asStateFlow()

    init {
        getAllTasks()
    }

    fun getAllTasks() {
        taskRepository.getAllTasks()
            .onEach { newValue ->
                _listOfTasks.value = newValue
            }
            .launchIn(viewModelScope)
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            taskRepository.updateTask(task = task)
        }
    }

    fun saveTask(
        text: String,
        colorPosition: Int
    ) {
        viewModelScope.launch {
            taskRepository.insertTaskIntoDatabase(
                Task(
                    text = text,
                    colorPosition = colorPosition
                )
            )
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskRepository.removeTaskFromDatabase(task = task)
        }
    }
}