package at.chrispi.teamranking.network.services

import at.chrispi.teamranking.network.dto.TeamDto
import retrofit2.Response
import retrofit2.http.GET

interface TeamService {
    @GET("clubs.json")
    suspend fun getTeams(): Response<List<TeamDto>>
}