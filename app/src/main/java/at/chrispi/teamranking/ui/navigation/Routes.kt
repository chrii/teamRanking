package at.chrispi.teamranking.ui.navigation

sealed class Routes(val route: String) {
    object TeamListScreen : Routes("team_list_screen")
    object TeamScreen : Routes("team_screen")
}