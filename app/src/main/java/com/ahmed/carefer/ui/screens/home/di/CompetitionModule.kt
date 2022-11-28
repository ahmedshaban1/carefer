package com.ahmed.carefer.ui.screens.home.di

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
    fun providesPropertyRemoteDataSource(api: CompetitionApi): CompetitionRemoteDataSource =
        CompetitionRemoteDataSourceImpl(api)

    @Singleton
    @Provides
    fun providesPropertyRepository(remoteDataSource: CompetitionRemoteDataSource): CompetitionRepository =
        CompetitionRepositoryImpl(remoteDataSource)

    @Singleton
    @Provides
    fun providesProApi(retrofit: Retrofit): CompetitionApi =
        retrofit.create(CompetitionApi::class.java)
}
