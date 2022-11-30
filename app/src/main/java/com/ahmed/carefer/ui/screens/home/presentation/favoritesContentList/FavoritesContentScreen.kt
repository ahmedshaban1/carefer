package com.ahmed.carefer.ui.screens.home.presentation.favoritesContentList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmed.carefer.R
import com.ahmed.carefer.ui.screens.home.presentation.components.MatchesList

@Composable
fun FavoritesContentScreen(viewModel: FavoritesViewModel = hiltViewModel()) {
    val viewState by viewModel.viewState.collectAsState()
    if (viewState.matchesDay.isEmpty()) FavoritesEmptyState()
    MatchesList(matchesDay = viewState.matchesDay) {
        viewModel.changeFavorite(it)
    }
}

@Composable
fun FavoritesEmptyState() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = stringResource(R.string.no_favorites), style = MaterialTheme.typography.h5)
    }
}
