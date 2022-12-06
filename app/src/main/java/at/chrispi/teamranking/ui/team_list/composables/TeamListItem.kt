package at.chrispi.teamranking.ui.team_list.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import at.chrispi.teamranking.R
import at.chrispi.teamranking.models.Team
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.RequestBuilderTransform

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TeamListItem(
    team: Team,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                modifier = Modifier
                    .padding(4.dp)
                    .size(100.dp),
                model = team.image,
                contentDescription = stringResource(R.string.team_list_picture_description),
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = team.teamName,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = team.country, style = MaterialTheme.typography.bodySmall
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.End),
                    text = stringResource(
                        R.string.team_list_item_team_value,
                        team.teamValue.toString()
                    ),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
        Divider()
    }
}