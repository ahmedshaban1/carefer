package com.ahmed.carefer.ui.screens.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed.carefer.models.CompetitionResponse
import com.ahmed.carefer.remote.errorhandling.IErrorCodes
import com.ahmed.carefer.remote.utilities.Resource
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
) : ViewModel() {

    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState = _viewState.asStateFlow()

    init {
        getHome()
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
                            isLoading = false,
                            competitionResponse = results.data ?: CompetitionResponse()
                        )
                    }
                }
            }
        }
    }

}
