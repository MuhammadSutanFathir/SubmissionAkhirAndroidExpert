package com.example.submissionandroidexpert.detail

import androidx.lifecycle.ViewModel
import com.example.submissionandroidexpert.core.domain.model.Team
import com.example.submissionandroidexpert.core.domain.usecase.TeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val teamUseCase: TeamUseCase) : ViewModel() {
    fun setFavoriteTeam(team: Team, newStatus:Boolean) =
        teamUseCase.setFavoriteTeam(team, newStatus)
}