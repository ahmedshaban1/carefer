package com.ahmed.carefer.ui.screens.home.presentation.allContentList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmed.carefer.R
import com.ahmed.carefer.ui.screens.home.presentation.components.MatchesList
import com.ahmed.carefer.ui.screens.shared_components.EmptyState
import com.ahmed.carefer.ui.screens.shared_components.LoadingDialog

@Composable
fun AllListContentScreen(viewModel: ListContentViewModel = hiltViewModel()) {
    val viewState by viewModel.viewState.collectAsState()
    if (viewState.isLoading) LoadingDialog()
    if (viewState.isEmpty) EmptyState(stringResource(id = R.string.no_match_days))

    MatchesList(matchesDay = viewState.matchesDay) {
        viewModel.changeFavorite(it)
    }
}
