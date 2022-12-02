package at.chrispi.teamranking.repositories

import at.chrispi.teamranking.models.Team
import at.chrispi.teamranking.network.DataState

interface ITeamRepository {
    suspend fun getTeams(): DataState<List<Team>>
}