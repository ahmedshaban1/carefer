package com.ahmed.carefer.ui.screens.home.domain.business

import com.ahmed.carefer.models.Matche
import javax.inject.Inject

class CompetitionBusiness @Inject constructor() {
    fun getMatchesByDay(matches: List<Matche>): Map<Int, List<Matche>> {
        return matches.groupBy { it.matchday }
    }
}