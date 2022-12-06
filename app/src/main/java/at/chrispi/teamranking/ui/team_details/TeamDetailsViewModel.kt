package at.chrispi.teamranking.ui.team_details

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import at.chrispi.teamranking.models.Team
import at.chrispi.teamranking.network.DataState
import at.chrispi.teamranking.repositories.ITeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamDetailsViewModel
@Inject
constructor(
    private val savedStateHandle: SavedStateHandle,
    private val teamRepository: ITeamRepository
) : ViewModel() {
    var team: MutableState<Team?> = mutableStateOf(null)

    fun getTeam(id: String) {
        val repoTeam = teamRepository.getTeam(id)
        try {
            if (repoTeam.hasData) {
                team.value = repoTeam.data!!
            } else {
                Log.d("ViewModel", repoTeam.message!!)
            }
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }
}