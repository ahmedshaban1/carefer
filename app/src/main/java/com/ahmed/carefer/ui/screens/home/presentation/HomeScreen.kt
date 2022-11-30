@file:OptIn(ExperimentalFoundationApi::class)

package com.ahmed.carefer.ui.screens.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ahmed.carefer.R
import com.ahmed.carefer.ui.screens.home.presentation.allContentList.AllListContentScreen
import com.ahmed.carefer.ui.screens.home.presentation.components.Tabs
import com.ahmed.carefer.ui.screens.home.presentation.favoritesContentList.FavoritesContentScreen
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
                    if (index == 0) {
                        AllListContentScreen()
                    } else {
                        FavoritesContentScreen()
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
