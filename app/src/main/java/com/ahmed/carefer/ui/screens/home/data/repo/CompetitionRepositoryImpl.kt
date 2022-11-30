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
        return localDataSource.getCompetition(filter)
    }

    override suspend fun changeFavorites(day: DayMatches) {
        localDataSource.changeFavorite(day)
    }

    override suspend fun saveCompetition(dayMatches: List<DayMatches>) {
        localDataSource.insertAllDays(dayMatches)
    }
}
