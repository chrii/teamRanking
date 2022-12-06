package at.chrispi.teamranking.repositories.implementations

import at.chrispi.teamranking.models.Team
import at.chrispi.teamranking.network.DataState
import at.chrispi.teamranking.network.services.TeamService
import at.chrispi.teamranking.repositories.ITeamRepository

class TeamRepository(
    private val teamService: TeamService
) : ITeamRepository {
    var teams: List<Team> = listOf()

    override suspend fun getTeams(): DataState<List<Team>> {
        try {
            val response = teamService.getTeams()
            return if (!response.isSuccessful) DataState(
                hasData = false,
                message = "Response was not successful",
                code = response.code(),
                data = null
            ) else {
                val teamEntity = response.body() ?: throw Exception("Response Body was null")
                val teamMap = teamEntity.map { it.convert() }
                teams = teamMap
                DataState(
                    hasData = true,
                    message = null,
                    code = response.code(),
                    data = teamMap,
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return DataState(
                hasData = false,
                message = e.message,
                code = null,
                data = null
            )
        }
    }
}