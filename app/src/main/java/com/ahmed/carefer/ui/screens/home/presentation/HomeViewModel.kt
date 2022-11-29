package com.ahmed.carefer.ui.screens.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed.carefer.models.DayMatches
import com.ahmed.carefer.remote.errorhandling.IErrorCodes
import com.ahmed.carefer.remote.utilities.Resource
import com.ahmed.carefer.ui.screens.home.domain.repo.CompetitionRepository
import com.ahmed.carefer.ui.screens.home.domain.usecases.ChangeFavoriteUseCase
import com.ahmed.carefer.ui.screens.home.domain.usecases.GetCompetitionUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val errorCodes: IErrorCodes,
    private val getCompetitionUserCase: GetCompetitionUserCase,
    private val changeFavoriteUseCase: ChangeFavoriteUseCase,
    private val repository: CompetitionRepository,

    ) : ViewModel() {

    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState = _viewState.asStateFlow()

    init {
        getHome()
        observerLocalHome()
    }

    private fun getHome() {
        viewModelScope.launch {
            getCompetitionUserCase().collectLatest { results ->
                when (results) {
                    is Resource.Error -> _viewState.update { state ->
                        state.copy(
                            errorMessage = errorCodes.getMessage(
                                results.errorCode
                            ), isLoading = false
                        )
                    }
                    Resource.Loading -> _viewState.update { state ->
                        state.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Success -> _viewState.update { state ->
                        state.copy(
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

    fun changeFavorite(dayMatches: DayMatches) {
        viewModelScope.launch {
            changeFavoriteUseCase(dayMatches)
        }
    }

    private fun observerLocalHome() {
        viewModelScope.launch {
            repository.getLocalCompetition().collectLatest { list ->
                _viewState.update { it.copy(matchesDay = list.toMutableList()) }
            }
        }
    }

}
