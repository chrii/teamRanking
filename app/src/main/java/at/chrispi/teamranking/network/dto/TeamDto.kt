package at.chrispi.teamranking.network.dto

import at.chrispi.teamranking.models.LatLng
import at.chrispi.teamranking.models.StadiumDetails
import at.chrispi.teamranking.models.Team
import com.squareup.moshi.Json

data class TeamDto(
    @field:Json(name = "id")
    val id: String?,

    @field:Json(name = "name")
    val teamName: String?,

    @field:Json(name = "country")
    val country: String?,

    @field:Json(name = "value")
    val value: Int?,

    @field:Json(name = "image")
    val image: String?,

    @field:Json(name = "european_titles")
    val europeanTitles: Int?,

    @field:Json(name = "stadium")
    val stadium: StadiumDetailsDto?,

    @field:Json(name = "location")
    val location: LonLatDto?,
) {
    fun convert(): Team = Team(
        id = id ?: "No value",
        teamName = teamName ?: "No value",
        country = country ?: "No value",
        value = value ?: 0,
        image = image ?: "No value",
        europeanTitles = europeanTitles ?: 0,
        stadium = stadium?.convert() ?: StadiumDetails(0, "No value"),
        location = location?.convert() ?: LatLng(0.0, 0.0),
    )
}