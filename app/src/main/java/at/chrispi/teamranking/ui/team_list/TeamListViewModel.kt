package at.chrispi.teamranking.ui.team_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.coroutineScope
import at.chrispi.teamranking.models.Team
import at.chrispi.teamranking.repositories.ITeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamListViewModel
@Inject
constructor(
    private val teamRepository: ITeamRepository
) : ViewModel() {
    val teamList: MutableState<List<Team>> = mutableStateOf(listOf())

    var loading: MutableState<Boolean> = mutableStateOf(false)
    var errorMessage: String = ""

    fun getTeams(lifecycle: Lifecycle) {
        loading.value = true

        lifecycle.coroutineScope.launch {
            val teams = teamRepository.getTeams()
            if(teams.hasData) {
                teamList.value = teams.data!!
                loading.value = false
            } else {
                errorMessage = teams.message ?: "No value"
            }
        }
    }
}