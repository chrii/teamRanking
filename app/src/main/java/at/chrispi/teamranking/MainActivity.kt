package at.chrispi.teamranking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import at.chrispi.teamranking.ui.navigation.Routes
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
                    NavHost(
                        navController = navController,
                        startDestination = Routes.TeamListScreen.route
                    ) {
                        composable(Routes.TeamListScreen.route) {
                            val viewModel: TeamListViewModel by viewModels()

                            TeamListScreen(viewModel)
                        }

                    }
                }
            }
        }
    }
}