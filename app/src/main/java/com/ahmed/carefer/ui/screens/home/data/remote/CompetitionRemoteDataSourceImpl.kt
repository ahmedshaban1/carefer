package com.ahmed.carefer.ui.screens.home.data.remote

import com.ahmed.carefer.models.CompetitionResponse
import javax.inject.Inject

class CompetitionRemoteDataSourceImpl @Inject constructor(private val api: CompetitionApi) :
    CompetitionRemoteDataSource {
    override suspend fun getCompetition(): CompetitionResponse {
        return api.getCompetition()
    }
}
