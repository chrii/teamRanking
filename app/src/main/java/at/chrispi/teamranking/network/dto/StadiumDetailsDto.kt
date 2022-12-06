package at.chrispi.teamranking.network.dto

import at.chrispi.teamranking.misc.Constants
import at.chrispi.teamranking.models.StadiumDetails
import com.squareup.moshi.Json

data class StadiumDetailsDto(
    @field:Json(name = "size")
    val space: Int?,

    @field:Json(name = "name")
    val name: String?
) {
    fun convert(): StadiumDetails = StadiumDetails(
        name = name ?: Constants.HAS_EMPTY_STRING_VALUE,
        space = space ?: Constants.HAS_EMPTY_INT_VALUE
    )
}