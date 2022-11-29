package com.ahmed.carefer.ui.screens.home.domain.usecases

import com.ahmed.carefer.remote.requester.RequestHandler
import com.ahmed.carefer.remote.utilities.Resource
import com.ahmed.carefer.remote.utilities.ResultWrapper
import com.ahmed.carefer.ui.screens.home.domain.business.CompetitionBusiness
import com.ahmed.carefer.ui.screens.home.domain.repo.CompetitionRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCompetitionUserCase @Inject constructor(
    private val repository: CompetitionRepository,
    private val requestHandler: RequestHandler,
    private val business: CompetitionBusiness
) : RequestHandler by requestHandler {

    suspend operator fun invoke() = flow {
        emit(Resource.Loading)
        val results = requestHandler.makeApiRequest {
            repository.getCompetition()
        }
        when (results) {
            is ResultWrapper.GenericError -> emit(Resource.Error(results.errorCode))
            is ResultWrapper.Success -> emit(
                Resource.Success(business.getMatchesByDay(results.value.matches).apply {
                    repository.saveCompetition(this.toList())
                })
            )
        }
    }
}
