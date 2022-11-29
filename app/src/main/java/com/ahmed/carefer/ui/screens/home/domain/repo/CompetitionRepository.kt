package com.ahmed.carefer.ui.screens.home.domain.repo

import com.ahmed.carefer.models.CompetitionResponse
import com.ahmed.carefer.models.DayMatches
import kotlinx.coroutines.flow.Flow

interface CompetitionRepository {
    suspend fun getCompetition(): CompetitionResponse
    suspend fun getLocalCompetition(): Flow<List<DayMatches>>
    suspend fun changeFavorites(day: DayMatches)
    suspend fun saveCompetition(dayMatches: List<DayMatches>)
}
