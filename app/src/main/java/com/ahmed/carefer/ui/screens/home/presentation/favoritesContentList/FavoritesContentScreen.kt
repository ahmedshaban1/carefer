package com.ahmed.carefer.ui.screens.home.presentation.favoritesContentList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmed.carefer.ui.screens.home.presentation.components.MatchesList


@Composable
fun FavoritesContentScreen(viewModel: FavoritesViewModel = hiltViewModel()) {
    val viewState by viewModel.viewState.collectAsState()
    MatchesList(matchesDay = viewState.matchesDay) {
        viewModel.changeFavorite(it)
    }
}