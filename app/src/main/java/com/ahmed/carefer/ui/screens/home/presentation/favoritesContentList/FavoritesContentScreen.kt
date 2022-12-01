package com.ahmed.carefer.ui.screens.home.presentation.favoritesContentList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmed.carefer.R
import com.ahmed.carefer.ui.screens.home.presentation.components.MatchesList
import com.ahmed.carefer.ui.screens.shared_components.EmptyState

@Composable
fun FavoritesContentScreen(viewModel: FavoritesViewModel = hiltViewModel()) {
    val viewState by viewModel.viewState.collectAsState()
    if (viewState.matchesDay.isEmpty()) EmptyState(stringResource(id = R.string.no_favorites))
    MatchesList(matchesDay = viewState.matchesDay) {
        viewModel.changeFavorite(it)
    }
}
