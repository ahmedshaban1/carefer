package com.ahmed.carefer.ui.screens.home.presentation.components

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.ahmed.carefer.R

sealed class Tabs(val tabName: Int, val selected: Boolean) {
    object All : Tabs(R.string.all_list, false)
    object Favorites : Tabs(R.string.favorites, false)
}

val tabItems = listOf(Tabs.All, Tabs.Favorites)


@Composable
fun Tabs(onTabChanged: (Int) -> Unit) {
    var selectedTab by remember { mutableStateOf(0) }
    TabRow(selectedTabIndex = selectedTab) {
        tabItems.forEachIndexed { index, it ->
            Tab(selected = selectedTab == index, onClick = {
                selectedTab = index
                onTabChanged(selectedTab)
            }, text = {
                Text(text = stringResource(id = it.tabName))
            }, selectedContentColor = Color.Magenta, unselectedContentColor = Color.White)
        }
    }
}