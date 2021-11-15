package com.denisithuku.cyptotrader.di

import com.denisithuku.cyptotrader.common.Constants
import com.denisithuku.cyptotrader.data.remote.CoinApiService
import com.denisithuku.cyptotrader.data.repository.CoinRepositoryImpl
import com.denisithuku.cyptotrader.domain.repository.CoinRepository
import com.denisithuku.cyptotrader.domain.use_cases.CoinUseCases
import com.denisithuku.cyptotrader.common.CoroutineDispatchers
import com.denisithuku.cyptotrader.domain.use_cases.GetAllCoins
import com.denisithuku.cyptotrader.domain.use_cases.GetCoinById
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCoinApiService(): CoinApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(CoinApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideCoinRepository(apiService: CoinApiService): CoinRepository {
        return CoinRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideCoinUseCases(repository: CoinRepository): CoinUseCases {
        return CoinUseCases(
            getAllCoins = GetAllCoins(repository),
            getCoinById = GetCoinById(repository)
        )
    }

    @Singleton
    @Provides
    fun provideCoroutineDispatchers(): CoroutineDispatchers {
        return CoroutineDispatchers(
            ioDispatcher = Dispatchers.IO,
            defaultDispatcher = Dispatchers.Default,
            mainDispatcher = Dispatchers.Main,
            unconfinedDispatcher = Dispatchers.Unconfined
        )
    }

}