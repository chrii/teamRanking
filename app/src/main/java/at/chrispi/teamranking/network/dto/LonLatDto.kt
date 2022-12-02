package at.chrispi.teamranking.network.dto

import at.chrispi.teamranking.models.LatLng
import com.squareup.moshi.Json

data class LonLatDto(
    @field:Json(name = "lat")
    val latitude: Double?,

    @field:Json(name = "lng")
    val longitude: Double?
) {
    fun convert(): LatLng = LatLng(
        longitude ?: 0.0,
        latitude ?: 0.0
    )
}