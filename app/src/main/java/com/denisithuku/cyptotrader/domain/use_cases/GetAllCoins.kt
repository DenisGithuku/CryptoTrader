package com.denisithuku.cyptotrader.domain.use_cases

import com.denisithuku.cyptotrader.common.Resource
import com.denisithuku.cyptotrader.data.remote.dto.toCoin
import com.denisithuku.cyptotrader.domain.model.Coin
import com.denisithuku.cyptotrader.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCoins @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins()
                .map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (exception: HttpException) {
            emit(Resource.Error<List<Coin>>(exception.localizedMessage ?: "Unexpected error occurred"))
        } catch (exception: IOException) {
            emit(Resource.Error<List<Coin>>("Unable to reach server check your internet connection"))
        }
    }
}