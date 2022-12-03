package com.ahmed.carefer.ui.screens.home.data.repo

import com.ahmed.carefer.helpers.CoroutinesMainDispatcherRule
import com.ahmed.carefer.helpers.FakeData.competitionResponse
import com.ahmed.carefer.helpers.FakeData.dayMatches
import com.ahmed.carefer.models.DayMatches
import com.ahmed.carefer.ui.screens.home.data.local.CompetitionLocalDataSource
import com.ahmed.carefer.ui.screens.home.data.remote.CompetitionRemoteDataSource
import com.ahmed.carefer.ui.screens.home.presentation.Filter
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class CompetitionRepositoryImplTest {
    private lateinit var sut: CompetitionRepositoryImpl

    @get:Rule
    var coroutinesMainDispatcherRule = CoroutinesMainDispatcherRule()
    private var collector: FlowCollector<List<DayMatches>> = mockk(relaxed = true)
    private val remoteDataSource = mockk<CompetitionRemoteDataSource>()
    private val localDataSource = mockk<CompetitionLocalDataSource>()
    private val expectedList = dayMatches.toList()

    @Before
    fun setUp() {
        sut = CompetitionRepositoryImpl(remoteDataSource, localDataSource)
    }


    @Test
    fun `Given getCompetition, get competition success from remote success`() = runBlocking {
        //arrange
        coEvery {
            remoteDataSource.getCompetition()
        } returns competitionResponse

        //act
        val results = sut.getCompetition()

        //assert
        coVerify {
            remoteDataSource.getCompetition()
        }
        assertEquals(results, competitionResponse)
    }

    @Test
    fun `Given Local getCompetition, get all days success from local success`() = runBlocking {
        //arrange
        coEvery {
            localDataSource.getAll()
        } returns flow { emit(expectedList) }

        //act
        sut.getLocalCompetition(Filter.ALL).collect(collector)

        //assert
        coVerify {
            collector.emit(expectedList)
        }
        coVerify(exactly = 1) {
            localDataSource.getAll()
        }

    }

    @Test
    fun `Given Local getCompetition, get favorites days success from local success`() = runBlocking {
        //arrange
        coEvery {
            localDataSource.getFavorites()
        } returns flow { emit(expectedList) }

        //act
        sut.getLocalCompetition(Filter.Favorites).collect(collector)
        //assert
        coVerify {
            collector.emit(expectedList)
        }
        coVerify(exactly = 1) {
            localDataSource.getFavorites()
        }

    }

    @Test
    fun `Given changeFavorites, change favorite status local`() = runBlocking {
        //arrange
        val dayInput = dayMatches[0]
        coEvery {
            localDataSource.updateDayMatch(any())
        } returns Unit
        //act
        sut.changeFavorites(dayInput)

        //assert
        coVerify(exactly = 1) {
            localDataSource.updateDayMatch(dayInput)
        }

    }


    @Test
    fun `Given save competition, save competition to local`() = runBlocking {
        //arrange
        coEvery {
            localDataSource.getDay(any())
        } returns null
        coEvery {
            localDataSource.insertDayMatch(any())
        } returns Unit
        //act
        sut.saveCompetition(dayMatches)

        //assert
        coVerify(atLeast = 1) {
            localDataSource.getDay(any())
            localDataSource.insertDayMatch(any())
        }
        coVerify(exactly = 0) {
            localDataSource.updateDayMatch(any())
        }
    }

    @Test
    fun `Given save competition, update competition to local`() = runBlocking {
        val day = dayMatches[0]
        //arrange
        coEvery {
            localDataSource.getDay(any())
        } returns day
        coEvery {
            localDataSource.updateDayMatch(any())
        } returns Unit
        //act
        sut.saveCompetition(dayMatches)

        //assert
        coVerify(atLeast = 1) {
            localDataSource.getDay(any())
            localDataSource.updateDayMatch(any())
        }
        coVerify(exactly = 0) {
            localDataSource.insertDayMatch(any())
        }
    }


}