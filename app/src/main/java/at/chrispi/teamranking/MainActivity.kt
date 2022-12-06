package at.chrispi.teamranking

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import at.chrispi.teamranking.models.Team
import at.chrispi.teamranking.ui.navigation.Routes
import at.chrispi.teamranking.ui.team_details.TeamDetailsScreen
import at.chrispi.teamranking.ui.team_details.TeamDetailsViewModel
import at.chrispi.teamranking.ui.team_list.TeamListScreen
import at.chrispi.teamranking.ui.team_list.TeamListViewModel
import at.chrispi.teamranking.ui.theme.TeamRankingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            TeamRankingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var activeTeam: Team? = null
                    NavHost(
                        navController = navController,
                        startDestination = Routes.TeamListScreen.route
                    ) {
                        composable(Routes.TeamListScreen.route) {
                            val viewModel: TeamListViewModel by viewModels()

                            TeamListScreen(
                                viewModel,
                                navController
                            )
                        }

                        composable(
                            route = Routes.TeamScreen.route + "/{teamId}",
                            arguments = listOf(navArgument("teamId") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val viewModel: TeamDetailsViewModel by viewModels()
                            val teamId: String? = backStackEntry.arguments?.getString("teamId")
                            teamId?.let { viewModel.getTeam(it) }

                            TeamDetailsScreen(
                                viewModel = viewModel,
                                navigation = navController
                            )
                        }
                    }
                }
            }
        }
    }
}