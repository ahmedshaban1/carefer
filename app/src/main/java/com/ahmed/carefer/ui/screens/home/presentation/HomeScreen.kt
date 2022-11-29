@file:OptIn(ExperimentalFoundationApi::class)

package com.ahmed.carefer.ui.screens.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmed.carefer.R
import com.ahmed.carefer.ui.screens.home.presentation.components.DayHeader
import com.ahmed.carefer.ui.screens.home.presentation.components.TeamResultItem

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterialApi
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val viewState by viewModel.viewState.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = { CreateTopBar() }) {
        LazyColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            if (viewState.matchesDay.isNotEmpty()) {
                viewState.matchesDay.forEach {
                    stickyHeader(key = it.day) {
                        DayHeader(number = it.day, isFavorite = it.isFavorite) {
                            viewModel.changeFavorite(it)
                        }
                    }
                    items(
                        it.matches,
                        key = { match ->
                            match.id
                        }
                    ) { match ->
                        TeamResultItem(match)
                    }
                }
            }
        }
    }
}

@Composable
fun CreateTopBar() {
    TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) })
}
