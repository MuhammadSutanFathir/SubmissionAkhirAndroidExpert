package com.example.submissionandroidexpert.core.di

import com.example.submissionandroidexpert.core.data.TeamRepository
import com.example.submissionandroidexpert.core.domain.repository.ITeamRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(teamRepository: TeamRepository): ITeamRepository

}