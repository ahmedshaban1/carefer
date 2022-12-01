package com.ahmed.carefer.ui.screens.home.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ahmed.carefer.helpers.getDateTime
import com.ahmed.carefer.models.MatchStatus
import com.ahmed.carefer.models.MatchType
import com.ahmed.carefer.models.Matche
import com.ahmed.carefer.models.Team

@Composable
fun TeamResultItem(
    match: Matche
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TeamsNames(match)
            if (match.status == MatchStatus.Finished.status) {
                TeamsScore(match)
            }
            if (match.status != MatchStatus.Finished.status) MatchStatus(match)
        }
    }
}

@Composable
fun TeamsNames(match: Matche) {
    Row(Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            TeamName(match.homeTeam)
        }
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            TeamName(match.awayTeam)
        }
    }
}

@Composable
fun TeamsScore(match: Matche) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        Score(match.score.fullTime.homeTeam, match.score.isWinner(MatchType.Home))
        Score(match.score.fullTime.awayTeam, match.score.isWinner(MatchType.Away))
    }
}

@Composable
fun TeamName(team: Team) {
    Text(
        text = team.name, style = MaterialTheme.typography.subtitle2, textAlign = TextAlign.Center
    )
}

@Composable
fun Score(results: Int, isWinner: Boolean) {
    Text(
        text = results.toString(), textAlign = TextAlign.Center, color = if (isWinner) Color.Green else Color.Black
    )
}

@Composable
fun MatchStatus(match: Matche) {
    Spacer(modifier = Modifier.height(10.dp))
    Text(text = match.status.lowercase())
    Text(text = match.utcDate.getDateTime() ?: "")
}
