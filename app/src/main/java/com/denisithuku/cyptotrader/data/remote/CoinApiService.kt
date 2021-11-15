package com.denisithuku.cyptotrader.data.remote

import com.denisithuku.cyptotrader.data.remote.dto.CoinDetailDto
import com.denisithuku.cyptotrader.data.remote.dto.CoinsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApiService {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinsDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}