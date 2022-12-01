package com.ahmed.carefer.ui.screens.home.domain.usecases

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ahmed.carefer.helpers.CoroutinesMainDispatcherRule
import com.ahmed.carefer.helpers.FakeData.competitionResponse
import com.ahmed.carefer.helpers.FakeData.dayMatches
import com.ahmed.carefer.models.DayMatches
import com.ahmed.carefer.remote.errorhandling.ErrorCodes
import com.ahmed.carefer.remote.requester.RequestHandlerImpl
import com.ahmed.carefer.remote.utilities.Resource
import com.ahmed.carefer.remote.utilities.ResultWrapper
import com.ahmed.carefer.ui.screens.home.domain.business.CompetitionBusiness
import com.ahmed.carefer.ui.screens.home.domain.repo.CompetitionRepository
import io.mockk.coEvery
import io.mockk.coVerifyOrder
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetCompetitionUserCaseTest {

    lateinit var sut: GetCompetitionUserCase

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesMainDispatcherRule = CoroutinesMainDispatcherRule()
    private var competitionRepository = spyk<CompetitionRepository>()
    private val requestHandler = spyk<RequestHandlerImpl>()
    private val competitionBusiness = mockk<CompetitionBusiness>()
    private var results: MutableList<Resource<List<DayMatches>>> = mutableListOf()

    @Before
    fun setUp() {
        sut = GetCompetitionUserCase(competitionRepository, requestHandler, competitionBusiness)
    }

    @Test
    fun `get filtered days, then get loading - success`() = runBlocking {
        // arrange

        coEvery {
            requestHandler.makeApiRequest {
                competitionRepository.getCompetition()
            }
        } returns ResultWrapper.Success(competitionResponse)
        coEvery { competitionRepository.getCompetition() } returns competitionResponse
        coEvery { competitionBusiness.getMatchesByDay(any()) } returns dayMatches

        // act

        sut().collect {
            results.add(it)
        }
        // assert
        coVerifyOrder {
            competitionRepository.getCompetition()
            competitionBusiness.getMatchesByDay(any())
            competitionRepository.saveCompetition(any())
        }

        assertTrue(results.size == 2)
        assertEquals(Resource.Loading, results[0])
        assertTrue(results[1] is Resource.Success)
        assertEquals(dayMatches.size, (results[1] as Resource.Success).data!!.size)
    }

    @Test
    fun `get filtered days, then get loading - Server Error`() = runBlocking {
        // arrange
        coEvery {
            requestHandler.makeApiRequest {
                competitionRepository.getCompetition()
            }
        } throws Throwable()
        coEvery { competitionRepository.getCompetition() } throws Throwable()

        // act

        sut().collect {
            results.add(it)
        }
        // assert
        coVerifyOrder {
            competitionRepository.getCompetition()
        }

        assertTrue(results.size == 2)
        assertEquals(Resource.Loading, results[0])
        assertTrue(results[1] is Resource.Error)
        assertEquals(ErrorCodes.GENERIC_ERROR, (results[1] as Resource.Error).errorCode)
    }
}
