package com.example.submissionandroidexpert.core.domain.usecase

import com.example.submissionandroidexpert.core.domain.model.Team
import com.example.submissionandroidexpert.core.domain.repository.ITeamRepository
import javax.inject.Inject

class TeamInteractor @Inject constructor(private val teamRepository: ITeamRepository) : TeamUseCase {
    override fun getAllTeam() = teamRepository.getAllTeam()

    override fun getFavoriteTeam() = teamRepository.getFavoriteTeam()

    override fun setFavoriteTeam(team: Team, state: Boolean) =
        teamRepository.setFavoriteTeam(team, state)

    override fun searchTeamByName(query: String) = teamRepository.searchTeamByName(query)

}