package com.ahmed.carefer.ui.screens.home.presentation

import com.ahmed.carefer.models.Matche


data class HomeViewState(
    val matchesDay: Map<Int, List<Matche>> = mapOf(),
    val errorMessage: String = "",
    val isLoading: Boolean = false,
)