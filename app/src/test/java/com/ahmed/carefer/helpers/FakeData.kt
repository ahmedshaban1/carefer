package com.ahmed.carefer.helpers

import com.ahmed.carefer.models.*

object FakeData {
    val matchesList: MutableList<Matche> = mutableListOf<Matche>().apply {
        add(
            Matche(
                awayTeam = Team(id = 1, name = "Ahly"),
                homeTeam = Team(id = 2, name = "Zamalek"),
                group = Any(),
                lastUpdated = "",
                id = 1,
                matchday = 1,
                odds = Odds(""),
                referees = listOf(),
                score = Score(
                    duration = "", extraTime = ExtraTime(Any(), Any()), fullTime = FullTime(6, 1), halfTime = HalfTime(3, 1), penalties = Penalties(Any(), Any()), winner = ""
                ),
                season = Season(
                    currentMatchday = 1, endDate = "", id = 1, startDate = ""
                ),
                stage = "",
                status = "",
                utcDate = ""
            )
        )
    }
    val competitionResponse = CompetitionResponse(matches = matchesList)
    val dayMatches: MutableList<DayMatches> = mutableListOf<DayMatches>().apply {
        add(DayMatches(1, matchesList))
    }
}
