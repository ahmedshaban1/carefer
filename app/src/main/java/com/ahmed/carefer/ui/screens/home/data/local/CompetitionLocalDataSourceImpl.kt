package com.ahmed.carefer.ui.screens.home.data.local

import com.ahmed.carefer.local.CompetitionDao
import com.ahmed.carefer.models.DayMatches
import com.ahmed.carefer.ui.screens.home.presentation.Filter
import kotlinx.coroutines.flow.Flow

class CompetitionLocalDataSourceImpl(
    private val competitionDao: CompetitionDao
) : CompetitionLocalDataSource {
    override suspend fun changeFavorite(day: DayMatches) {
        competitionDao.update(day.apply {
            isFavorite = !this.isFavorite
        })
    }

    override suspend fun insertAllDays(list: List<DayMatches>) {
        list.forEach { dayMatches ->
            competitionDao.getDay(dayMatches.day)?.let {
                // update
                competitionDao.update(it.apply {
                    matches = dayMatches.matches
                })
            } ?: kotlin.run {
                // insert
                competitionDao.insert(dayMatches)
            }
        }
    }

    override suspend fun getCompetition(filter: Filter): Flow<List<DayMatches>> {
        return when (filter) {
            Filter.ALL -> competitionDao.getAll()
            Filter.Favorites -> competitionDao.getFavorites()
        }
    }
}
