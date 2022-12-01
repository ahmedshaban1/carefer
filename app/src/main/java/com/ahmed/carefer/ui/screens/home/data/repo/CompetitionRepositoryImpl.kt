package com.ahmed.carefer.ui.screens.home.data.repo

import com.ahmed.carefer.models.CompetitionResponse
import com.ahmed.carefer.models.DayMatches
import com.ahmed.carefer.ui.screens.home.data.local.CompetitionLocalDataSource
import com.ahmed.carefer.ui.screens.home.data.remote.CompetitionRemoteDataSource
import com.ahmed.carefer.ui.screens.home.domain.repo.CompetitionRepository
import com.ahmed.carefer.ui.screens.home.presentation.Filter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CompetitionRepositoryImpl @Inject constructor(
    private val remote: CompetitionRemoteDataSource,
    private val localDataSource: CompetitionLocalDataSource
) : CompetitionRepository {

    override suspend fun getCompetition(): CompetitionResponse {
        return remote.getCompetition()
    }

    override suspend fun getLocalCompetition(filter: Filter): Flow<List<DayMatches>> {
        return when (filter) {
            Filter.ALL -> localDataSource.getAll()
            Filter.Favorites -> localDataSource.getFavorites()
        }
    }

    override suspend fun changeFavorites(day: DayMatches) {
        localDataSource.updateDayMatch(day)
    }

    override suspend fun saveCompetition(dayMatches: List<DayMatches>) {
        dayMatches.forEach { dayMatch ->
            localDataSource.getDay(dayMatch.day)?.let {
                // update
                localDataSource.updateDayMatch(
                    it.apply {
                        matches = dayMatch.matches
                    }
                )
            } ?: kotlin.run {
                // insert
                localDataSource.insertDayMatch(dayMatch)
            }
        }
    }
}
