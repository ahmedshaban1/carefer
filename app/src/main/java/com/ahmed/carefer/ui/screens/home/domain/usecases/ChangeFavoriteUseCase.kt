package com.ahmed.carefer.ui.screens.home.domain.usecases

import com.ahmed.carefer.models.DayMatches
import com.ahmed.carefer.ui.screens.home.domain.repo.CompetitionRepository
import javax.inject.Inject

class ChangeFavoriteUseCase @Inject constructor(private val repository: CompetitionRepository) {
    suspend operator fun invoke(day: DayMatches) {
        repository.changeFavorites(day)
    }
}