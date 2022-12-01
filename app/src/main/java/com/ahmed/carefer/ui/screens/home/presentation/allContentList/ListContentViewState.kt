package com.ahmed.carefer.ui.screens.home.presentation.allContentList

import com.ahmed.carefer.models.DayMatches

data class ListContentViewState(
    val errorMessage: String = "",
    val isLoading: Boolean = false,
    val matchesDay: MutableList<DayMatches> = mutableListOf(),
    val isEmpty: Boolean = false
)
