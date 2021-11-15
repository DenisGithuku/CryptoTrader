package com.denisithuku.cyptotrader.data.repository

import com.denisithuku.cyptotrader.data.remote.CoinApiService
import com.denisithuku.cyptotrader.data.remote.dto.CoinDetailDto
import com.denisithuku.cyptotrader.data.remote.dto.CoinsDto
import com.denisithuku.cyptotrader.domain.repository.CoinRepository
import javax.inject.Inject


class CoinRepositoryImpl @Inject constructor(
    private val coinApiService: CoinApiService
): CoinRepository {
    override suspend fun getCoins(): List<CoinsDto> {
        return coinApiService.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coinApiService.getCoinById(coinId)
    }


}