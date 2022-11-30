package com.ahmed.carefer.ui.screens.home.presentation.favoritesContentList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed.carefer.models.DayMatches
import com.ahmed.carefer.ui.screens.home.domain.repo.CompetitionRepository
import com.ahmed.carefer.ui.screens.home.domain.usecases.ChangeFavoriteUseCase
import com.ahmed.carefer.ui.screens.home.presentation.Filter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val changeFavoriteUseCase: ChangeFavoriteUseCase,
    private val repository: CompetitionRepository,

) : ViewModel() {

    private val _viewState = MutableStateFlow(FavoritesViewState())
    val viewState = _viewState.asStateFlow()

    init {
        getLocalHome()
    }

    fun changeFavorite(dayMatches: DayMatches) {
        viewModelScope.launch {
            changeFavoriteUseCase(dayMatches)
        }
    }

    private fun getLocalHome() {
        viewModelScope.launch {
            repository.getLocalCompetition(Filter.Favorites).collectLatest { list ->
                _viewState.update { it.copy(matchesDay = list.toMutableList()) }
            }
        }
    }
}
