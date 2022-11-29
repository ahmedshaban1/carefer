package com.ahmed.carefer.models

data class CompetitionResponse(
    val competition: Competition = Competition(),
    val count: Int = 0,
    val filters: Filters = Filters(),
    val matches: MutableList<Matche> = mutableListOf()
)
