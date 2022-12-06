package at.chrispi.teamranking.ui.team_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import at.chrispi.teamranking.R
import at.chrispi.teamranking.models.Team

@Composable
fun TeamDetailsScreen(
    viewModel: TeamDetailsViewModel,
    navigation: NavController
) {
    if (viewModel.team.value == null) {
        var openDialog by remember { mutableStateOf(true) }
        Column(modifier = Modifier.fillMaxSize()) {
            AlertDialog(
                onDismissRequest = {
                    openDialog = false
                }, confirmButton = {
                    Button(onClick = { navigation.popBackStack() }) {
                        Text(stringResource(id = R.string.team_details_alert_dialog_back_button))
                    }
                },
                title = {
                    Text(stringResource(R.string.team_details_alert_dialog_title))
                },
                text = {
                    Text(stringResource(R.string.team_details_alert_dialog_content))
                }
            )
        }
    }
}