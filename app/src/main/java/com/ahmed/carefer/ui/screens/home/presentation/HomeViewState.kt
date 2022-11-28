package com.ahmed.carefer.ui.screens.home.presentation

import com.ahmed.carefer.models.CompetitionResponse


data class HomeViewState(
    val competitionResponse: CompetitionResponse = CompetitionResponse(),
    val errorMessage: String = "",
    val isLoading: Boolean = false,
)