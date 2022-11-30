package com.ahmed.carefer.ui.screens.home.data.local

import com.ahmed.carefer.models.DayMatches
import com.ahmed.carefer.ui.screens.home.presentation.Filter
import kotlinx.coroutines.flow.Flow

interface CompetitionLocalDataSource {
    suspend fun changeFavorite(day: DayMatches)
    suspend fun insertAllDays(list: List<DayMatches>)
    suspend fun getCompetition(filter: Filter): Flow<List<DayMatches>>
}
