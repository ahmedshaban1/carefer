package com.ahmed.carefer.ui.screens.home.domain.business

import com.ahmed.carefer.models.DayMatches
import com.ahmed.carefer.models.Matche
import javax.inject.Inject


class CompetitionBusiness @Inject constructor() {
    fun getMatchesByDay(matches: List<Matche>): MutableList<DayMatches> {
        return matches.groupBy { it.matchday }.map { DayMatches(it.key, it.value, false) }.toMutableList()
    }
}
