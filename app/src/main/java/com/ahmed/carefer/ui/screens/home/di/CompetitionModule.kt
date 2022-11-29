package com.ahmed.carefer.ui.screens.home.di

import com.ahmed.carefer.local.AppDatabase
import com.ahmed.carefer.ui.screens.home.data.local.CompetitionLocalDataSource
import com.ahmed.carefer.ui.screens.home.data.local.CompetitionLocalDataSourceImpl
import com.ahmed.carefer.ui.screens.home.data.remote.CompetitionApi
import com.ahmed.carefer.ui.screens.home.data.remote.CompetitionRemoteDataSource
import com.ahmed.carefer.ui.screens.home.data.remote.CompetitionRemoteDataSourceImpl
import com.ahmed.carefer.ui.screens.home.data.repo.CompetitionRepositoryImpl
import com.ahmed.carefer.ui.screens.home.domain.repo.CompetitionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CompetitionModule {

    @Singleton
    @Provides
    fun providesCompetitionRemoteDataSource(api: CompetitionApi): CompetitionRemoteDataSource =
        CompetitionRemoteDataSourceImpl(api)

    @Singleton
    @Provides
    fun providesCompetitionLocalDataSource(db: AppDatabase): CompetitionLocalDataSource =
        CompetitionLocalDataSourceImpl(db.competitionDao)

    @Singleton
    @Provides
    fun providesCompetitionRepository(
        remoteDataSource: CompetitionRemoteDataSource,
        localDataSource: CompetitionLocalDataSource
    ): CompetitionRepository = CompetitionRepositoryImpl(remoteDataSource, localDataSource)

    @Singleton
    @Provides
    fun CompetitionApi(retrofit: Retrofit): CompetitionApi =
        retrofit.create(CompetitionApi::class.java)
}
