package com.ahmed.carefer.ui.screens.home.presentation.favoritesContentList

import com.ahmed.carefer.models.DayMatches

data class FavoritesViewState(
    val matchesDay: MutableList<DayMatches> = mutableListOf(),
)
