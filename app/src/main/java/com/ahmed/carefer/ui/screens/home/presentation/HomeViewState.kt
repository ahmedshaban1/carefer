package com.ahmed.carefer.ui.screens.home.presentation

import com.ahmed.carefer.models.DayMatches


data class HomeViewState(
    val errorMessage: String = "",
    val isLoading: Boolean = false,
    val matchesDay: MutableList<DayMatches> = mutableListOf(),
)