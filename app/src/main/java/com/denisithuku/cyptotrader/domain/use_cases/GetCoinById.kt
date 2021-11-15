package com.denisithuku.cyptotrader.domain.use_cases

import com.denisithuku.cyptotrader.common.Resource
import com.denisithuku.cyptotrader.data.remote.dto.toCoinDetail
import com.denisithuku.cyptotrader.domain.model.CoinDetail
import com.denisithuku.cyptotrader.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinById @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))

        }catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Unable to read server check your internet connection"))
        }
    }
}