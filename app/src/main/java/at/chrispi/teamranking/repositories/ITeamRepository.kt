package at.chrispi.teamranking.repositories

import at.chrispi.teamranking.models.Team
import at.chrispi.teamranking.network.DataState

interface ITeamRepository {
    fun getTeam(id: String): DataState<Team>
    suspend fun getTeams(): DataState<List<Team>>
}