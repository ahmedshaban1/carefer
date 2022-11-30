@file:OptIn(ExperimentalFoundationApi::class)

package com.ahmed.carefer.ui.screens.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmed.carefer.R
import com.ahmed.carefer.ui.screens.home.presentation.components.DayHeader
import com.ahmed.carefer.ui.screens.home.presentation.components.Tabs
import com.ahmed.carefer.ui.screens.home.presentation.components.TeamResultItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen() {

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = { CreateTopBar() }) {
        val pagerState = rememberPagerState(
            pageCount = 2,
            initialOffscreenLimit = 2,
            infiniteLoop = true,
            initialPage = 0,
        )
        val tabIndex = pagerState.currentPage
        val coroutineScope = rememberCoroutineScope()

        Column(Modifier.fillMaxWidth()) {
            Tabs { index ->
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                }
            }

            HorizontalPager(
                state = pagerState, modifier = Modifier.weight(1f)
            ) { index ->
                Column(
                    modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (index == 0){
                        ListContent(filter = Filter.ALL)
                    }else {
                        ListContent(filter = Filter.Favorites)
                    }
                }
            }

        }

    }
}


@Composable
fun ListContent(viewModel: HomeViewModel = hiltViewModel(),filter: Filter) {
    val viewState by viewModel.viewState.collectAsState()
    LaunchedEffect(key1 = true){
        viewModel.getLocalHome(filter)
    }
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
                items(it.matches, key = { match ->
                    match.id
                }) { match ->
                    TeamResultItem(match)
                }
            }
        }
    }
}

@Composable
fun CreateTopBar() {
    TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) })
}
