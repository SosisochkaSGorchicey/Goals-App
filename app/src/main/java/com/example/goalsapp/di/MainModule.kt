package com.example.goalsapp.di

import android.content.Context
import androidx.room.Room
import com.example.goalsapp.data.datasource.dao.ChallengeDao
import com.example.goalsapp.data.datasource.db.GoalDatabase
import com.example.goalsapp.data.repository.ChallengeRepositoryImpl
import com.example.goalsapp.domain.repository.ChallengeRepository
import com.example.goalsapp.presentation.screens.goals_screen.viewmodel.ChallengesViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MainModule {
    val module = module {
        single { provideDatabase(context = androidApplication()) }
        single { provideChallengeDao(goalDatabase = get()) }

        single<ChallengeRepository> { ChallengeRepositoryImpl(dao = get()) }


        viewModel {
            ChallengesViewModel(
                challengeRepository = get()
            )
        }
    }

    private const val databaseName = "goalsDatabase.db"

    private fun provideDatabase(context: Context): GoalDatabase =
        Room.databaseBuilder(
            context,
            GoalDatabase::class.java,
            databaseName
        ).build()

    private fun provideChallengeDao(goalDatabase: GoalDatabase): ChallengeDao =
        goalDatabase.challengeDao()
}