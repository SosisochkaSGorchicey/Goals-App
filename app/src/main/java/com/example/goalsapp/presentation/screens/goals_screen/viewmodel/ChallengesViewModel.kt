package com.example.goalsapp.presentation.screens.goals_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goalsapp.domain.model.Challenge
import com.example.goalsapp.domain.repository.ChallengeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ChallengesViewModel(
    private val challengeRepository: ChallengeRepository
) : ViewModel() {

    private val _listOfChallenges = MutableStateFlow(listOf<Challenge>())
    val listOfChallenges = _listOfChallenges.asStateFlow()

    fun getAllChallenges() {
        challengeRepository.getAllChallenges()
            .onEach { newValue ->
                _listOfChallenges.value = newValue
            }
            .launchIn(viewModelScope)
    }

    fun updateChallenge(challenge: Challenge) {
        viewModelScope.launch {
            challengeRepository.updateChallenge(challenge = challenge)
        }
    }

    fun removeChallengeFromDatabase(challenge: Challenge) {
        viewModelScope.launch {
            challengeRepository.removeChallengeFromDatabase(challenge = challenge)
        }
    }

    fun insertChallengeIntoDatabase(
        title: String,
        text: String,
        iconKey: Int,
        goalValue: Int,
        addingValue: Int
    ) {
        viewModelScope.launch {
            challengeRepository.insertChallengeIntoDatabase(
                Challenge(
                    title = title,
                    text = text,
                    iconKey = iconKey,
                    goalValue = goalValue,
                    addingValue = addingValue
                )
            )
        }
    }
}