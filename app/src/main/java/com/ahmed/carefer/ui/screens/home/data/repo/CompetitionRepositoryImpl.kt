package com.ahmed.carefer.ui.screens.home.data.repo

import com.ahmed.carefer.models.CompetitionResponse
import com.ahmed.carefer.ui.screens.home.data.remote.CompetitionRemoteDataSource
import com.ahmed.carefer.ui.screens.home.domain.repo.CompetitionRepository
import javax.inject.Inject

class CompetitionRepositoryImpl @Inject constructor(private val remote: CompetitionRemoteDataSource) :
    CompetitionRepository {

    override suspend fun getCompetition(): CompetitionResponse {
        return remote.getCompetition()
    }
}
