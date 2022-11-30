package com.ahmed.carefer.ui.screens.home.presentation.allContentList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed.carefer.models.DayMatches
import com.ahmed.carefer.remote.errorhandling.IErrorCodes
import com.ahmed.carefer.remote.utilities.Resource
import com.ahmed.carefer.ui.screens.home.domain.repo.CompetitionRepository
import com.ahmed.carefer.ui.screens.home.domain.usecases.ChangeFavoriteUseCase
import com.ahmed.carefer.ui.screens.home.domain.usecases.GetCompetitionUserCase
import com.ahmed.carefer.ui.screens.home.presentation.Filter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListContentViewModel @Inject constructor(
    private val errorCodes: IErrorCodes,
    private val getCompetitionUserCase: GetCompetitionUserCase,
    private val changeFavoriteUseCase: ChangeFavoriteUseCase,
    private val repository: CompetitionRepository,

    ) : ViewModel() {

    private val _viewState = MutableStateFlow(ListContentViewState())
    val viewState = _viewState.asStateFlow()


    init {
        getHome()
        getLocalHome()
    }

    private fun getHome() {
        viewModelScope.launch {
            getCompetitionUserCase().collectLatest { results ->
                when (results) {
                    is Resource.Error -> {
                        Log.e("errror", "ssssssss")
                        _viewState.update { state ->
                            state.copy(
                                isLoading = false, errorMessage = errorCodes.getMessage(
                                    results.errorCode
                                )
                            )

                        }
                    }
                    Resource.Loading -> _viewState.update { state ->
                        state.copy(
                            isLoading = true, errorMessage = ""
                        )
                    }
                    is Resource.Success -> _viewState.update { state ->
                        state.copy(
                            isLoading = false, errorMessage = ""
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

    private fun getLocalHome(filter: Filter = Filter.ALL) {
        viewModelScope.launch {
            repository.getLocalCompetition(filter).collectLatest { list ->
                _viewState.update {
                    it.copy(
                        matchesDay = list.toMutableList(),
                        isEmpty = list.isEmpty(),
                    )
                }
            }
        }
    }

    fun removeErrorMessage() {
        _viewState.update {
            it.copy(errorMessage = "")
        }
    }
}
