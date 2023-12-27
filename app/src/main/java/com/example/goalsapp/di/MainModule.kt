package com.example.goalsapp.di

import android.content.Context
import androidx.room.Room
import com.example.goalsapp.data.datasource.dao.ChallengeDao
import com.example.goalsapp.data.datasource.dao.TaskDao
import com.example.goalsapp.data.datasource.db.MainDatabase
import com.example.goalsapp.data.repository.ChallengeRepositoryImpl
import com.example.goalsapp.data.repository.TaskRepositoryImpl
import com.example.goalsapp.domain.repository.ChallengeRepository
import com.example.goalsapp.domain.repository.TaskRepository
import com.example.goalsapp.presentation.screens.goals_screen.viewmodel.ChallengesViewModel
import com.example.goalsapp.presentation.screens.planer_screen.viewmodel.PlanerViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MainModule {
    val module = module {
        single { provideDatabase(context = androidApplication()) }
        single { provideChallengeDao(mainDatabase = get()) }
        single { provideTaskDao(mainDatabase = get()) }

        single<ChallengeRepository> { ChallengeRepositoryImpl(dao = get()) }
        single<TaskRepository> { TaskRepositoryImpl(taskDao = get()) }


        viewModel {
            ChallengesViewModel(
                challengeRepository = get()
            )
        }

        viewModel {
            PlanerViewModel(
                taskRepository = get()
            )
        }
    }

    private const val databaseName = "goalsDatabase.db"

    private fun provideDatabase(context: Context): MainDatabase =
        Room.databaseBuilder(
            context,
            MainDatabase::class.java,
            databaseName
        ).build()

    private fun provideChallengeDao(mainDatabase: MainDatabase): ChallengeDao =
        mainDatabase.challengeDao()

    private fun provideTaskDao(mainDatabase: MainDatabase): TaskDao =
        mainDatabase.taskDao()
}