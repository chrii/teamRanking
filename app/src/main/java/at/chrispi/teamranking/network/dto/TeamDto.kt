package at.chrispi.teamranking.network.dto

import at.chrispi.teamranking.misc.Constants
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
        teamName = teamName ?: Constants.HAS_EMPTY_STRING_VALUE,
        country = country ?: Constants.HAS_EMPTY_STRING_VALUE,
        value = value ?: Constants.HAS_EMPTY_INT_VALUE,
        image = image ?: Constants.HAS_EMPTY_STRING_VALUE,
        europeanTitles = europeanTitles ?: Constants.HAS_EMPTY_INT_VALUE,
        stadium = stadium?.convert() ?: StadiumDetails(
            Constants.HAS_EMPTY_INT_VALUE,
            Constants.HAS_EMPTY_STRING_VALUE
        ),
        location = location?.convert() ?: LatLng(
            Constants.HAS_EMPTY_DOUBLE_VALUE,
            Constants.HAS_EMPTY_DOUBLE_VALUE
        ),
    )
}