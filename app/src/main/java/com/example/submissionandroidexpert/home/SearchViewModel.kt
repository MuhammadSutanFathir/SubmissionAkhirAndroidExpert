package com.example.submissionandroidexpert.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.submissionandroidexpert.core.domain.usecase.TeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val teamUseCase: TeamUseCase) : ViewModel() {
    fun searchTeam(query: String)= teamUseCase.searchTeamByName(query).asLiveData()
}