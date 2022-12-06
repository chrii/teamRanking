package at.chrispi.teamranking.ui.team_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import at.chrispi.teamranking.ui.composables.LoadingIndicator
import at.chrispi.teamranking.ui.navigation.Routes
import at.chrispi.teamranking.ui.team_list.composables.EmptyScreen
import at.chrispi.teamranking.ui.team_list.composables.TeamListItem

@Composable
fun TeamListScreen(
    viewModel: TeamListViewModel,
//    onClick: (team: Team) -> Unit
    navigation: NavController
) {
    val lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle

    when {
        viewModel.loading.value -> LoadingIndicator()
        viewModel.teamList.value.isEmpty() -> {
            EmptyScreen()
            viewModel.getTeams(lifecycle)
        }
        else -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(viewModel.teamList.value) { team ->
                    TeamListItem(team = team) {
                        navigation.navigate("${Routes.TeamScreen.route}/${team.id}")
                    }
                }
            }
        }
    }
}