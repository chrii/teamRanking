package at.chrispi.teamranking.models

data class Team(
    val id: String,
    val teamName: String,
    val country: String,
    val teamValue: Int,
    val image: String,
    val europeanTitles: Int,
    val stadium: StadiumDetails,
    val location: LatLng,
)
