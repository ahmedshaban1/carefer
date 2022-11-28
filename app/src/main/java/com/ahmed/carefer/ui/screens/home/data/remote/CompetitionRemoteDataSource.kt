package com.ahmed.carefer.ui.screens.home.data.remote

import com.ahmed.carefer.models.CompetitionResponse


interface CompetitionRemoteDataSource {
    suspend fun getCompetition(): CompetitionResponse
}
