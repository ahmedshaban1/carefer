package com.ahmed.carefer.ui.screens.home.data.local

import com.ahmed.carefer.models.DayMatches
import kotlinx.coroutines.flow.Flow

interface CompetitionLocalDataSource {
    suspend fun getAll(): Flow<List<DayMatches>>
    suspend fun getFavorites(): Flow<List<DayMatches>>
    suspend fun getDay(day: Int): DayMatches?
    suspend fun insertDayMatch(dayMatches: DayMatches)
    suspend fun updateDayMatch(dayMatches: DayMatches)
}
