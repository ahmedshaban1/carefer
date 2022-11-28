package com.ahmed.carefer.ui.screens.home.data.remote

import com.ahmed.carefer.models.CompetitionResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface CompetitionApi {
    @Headers("X-Auth-Token: 15ce0f9561584c7db17f27851883bccc")
    @GET("competitions/2021/matches")
    suspend fun getCompetition(): CompetitionResponse
}
