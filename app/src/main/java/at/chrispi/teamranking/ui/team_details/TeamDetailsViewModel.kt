package at.chrispi.teamranking.ui.team_details

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import at.chrispi.teamranking.R
import at.chrispi.teamranking.misc.Constants
import at.chrispi.teamranking.models.Team
import at.chrispi.teamranking.network.DataState
import at.chrispi.teamranking.repositories.ITeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamDetailsViewModel
@Inject
constructor(
    private val teamRepository: ITeamRepository
) : ViewModel() {
    var team: MutableState<Team?> = mutableStateOf(null)
    var errorMessage: String = Constants.HAS_EMPTY_STRING_VALUE

    fun getTeam(id: String, context: Context) {
        val repoTeam = teamRepository.getTeam(id)
        try {
            if (repoTeam.hasData) {
                team.value = repoTeam.data!!
            } else {
                errorMessage = if (repoTeam.message == Constants.HAS_EMPTY_STRING_VALUE) {
                    context.getString(R.string.team_details_alert_dialog_content)
                } else "No Error Message provided on getTeam(teamId)"
            }
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }
}