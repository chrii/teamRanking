package at.chrispi.teamranking.ui.team_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import at.chrispi.teamranking.ui.composables.LoadingIndicator
import at.chrispi.teamranking.ui.team_list.composables.EmptyScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamListScreen(
    viewModel: TeamListViewModel
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
                    ListItem(
                        modifier = Modifier.fillMaxWidth(),
                        headlineText = { Text(team.teamName) },
                        supportingText = { Text(team.country) },
                        shadowElevation = 20.dp
                    )
                }
            }
        }
    }
}