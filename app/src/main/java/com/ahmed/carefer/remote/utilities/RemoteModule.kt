package com.ahmed.carefer.remote.utilities

import android.content.Context
import com.ahmed.carefer.BuildConfig
import com.ahmed.carefer.R
import com.ahmed.carefer.remote.requester.RequestHandler
import com.ahmed.carefer.remote.requester.RequestHandlerImpl
import com.ahmed.carefer.remote.utilities.Constants.baseUrl
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RemoteModule {
    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun providesClient(
        logger: Interceptor, defaultInterceptor: DefaultInterceptor
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(logger)
            .addInterceptor(defaultInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor()
            .setLevel(
                if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
            )
    }

    @Provides
    @Singleton
    fun provideDefaultInterceptor(@ApplicationContext context: Context): DefaultInterceptor {
        return DefaultInterceptor(context.getString(R.string.api_key))
    }

    @Provides
    @Singleton
    fun providesRequestHandler(): RequestHandler = RequestHandlerImpl()
}
