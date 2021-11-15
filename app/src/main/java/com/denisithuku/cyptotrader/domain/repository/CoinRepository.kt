package com.denisithuku.cyptotrader.domain.repository

import com.denisithuku.cyptotrader.data.remote.dto.CoinDetailDto
import com.denisithuku.cyptotrader.data.remote.dto.CoinsDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinsDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}