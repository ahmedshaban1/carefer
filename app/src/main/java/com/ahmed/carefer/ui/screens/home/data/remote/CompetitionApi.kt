package com.ahmed.carefer.ui.screens.home.data.remote

import com.ahmed.carefer.models.CompetitionResponse
import retrofit2.http.GET

interface CompetitionApi {
    @GET("competitions/2021/matches")
    suspend fun getCompetition(): CompetitionResponse
}
