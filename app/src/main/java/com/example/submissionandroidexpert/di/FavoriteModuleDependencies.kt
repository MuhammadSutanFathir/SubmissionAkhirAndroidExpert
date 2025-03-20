package com.example.submissionandroidexpert.di

import com.example.submissionandroidexpert.core.domain.usecase.TeamUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {

    fun teamUseCase(): TeamUseCase
}