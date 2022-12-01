package com.ahmed.carefer.ui.screens.home.data.local

import com.ahmed.carefer.local.CompetitionDao
import com.ahmed.carefer.models.DayMatches
import kotlinx.coroutines.flow.Flow

class CompetitionLocalDataSourceImpl(
    private val competitionDao: CompetitionDao
) : CompetitionLocalDataSource {

    override suspend fun updateDayMatch(dayMatches: DayMatches) {
        competitionDao.update(dayMatches)
    }

    override suspend fun getDay(day: Int): DayMatches? {
        return competitionDao.getDay(day)
    }

    override suspend fun insertDayMatch(dayMatches: DayMatches) {
        competitionDao.insert(dayMatches)
    }

    override suspend fun getAll(): Flow<List<DayMatches>> {
        return competitionDao.getAll()
    }

    override suspend fun getFavorites(): Flow<List<DayMatches>> {
        return competitionDao.getFavorites()
    }
}
