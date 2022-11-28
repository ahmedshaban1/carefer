package com.ahmed.carefer.remote.errorhandling

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ErrorCodesModule {
    @Provides
    @Singleton
    fun providesErrorCodes(@ApplicationContext context: Context): IErrorCodes = ErrorCodesImpl(context.resources)
}
