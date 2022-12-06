package at.chrispi.teamranking.network.dto

import at.chrispi.teamranking.misc.Constants
import at.chrispi.teamranking.models.LatLng
import com.squareup.moshi.Json

data class LonLatDto(
    @field:Json(name = "lat")
    val latitude: Double?,

    @field:Json(name = "lng")
    val longitude: Double?
) {
    fun convert(): LatLng = LatLng(
        longitude ?: Constants.HAS_EMPTY_DOUBLE_VALUE,
        latitude ?: Constants.HAS_EMPTY_DOUBLE_VALUE
    )
}