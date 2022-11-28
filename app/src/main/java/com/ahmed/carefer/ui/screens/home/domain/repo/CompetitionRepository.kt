package com.ahmed.carefer.ui.screens.home.domain.repo

import com.ahmed.carefer.models.CompetitionResponse


interface CompetitionRepository {
    suspend fun getCompetition(): CompetitionResponse
}
