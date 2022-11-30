@file:OptIn(ExperimentalFoundationApi::class)

package com.ahmed.carefer.ui.screens.home.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ahmed.carefer.models.DayMatches

@Composable
fun MatchesList(matchesDay: List<DayMatches>, onFavoriteClicked: (DayMatches) -> Unit) {
    LazyColumn(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        if (matchesDay.isNotEmpty()) {
            matchesDay.forEach {
                stickyHeader(key = it.day) {
                    DayHeader(number = it.day, isFavorite = it.isFavorite) {
                        onFavoriteClicked(it)
                    }
                }
                items(it.matches, key = { match ->
                    match.id
                }) { match ->
                    TeamResultItem(match)
                }
            }
        }
    }

}