package com.denisithuku.cyptotrader.presentation.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denisithuku.cyptotrader.presentation.util.CoinDetailState
import com.denisithuku.cyptotrader.common.Constants
import com.denisithuku.cyptotrader.common.Resource
import com.denisithuku.cyptotrader.domain.use_cases.CoinUseCases
import com.denisithuku.cyptotrader.common.CoroutineDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val coinUseCases: CoinUseCases,
    private val coroutineDispatchers: CoroutineDispatchers,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf<CoinDetailState>(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.paramCoinId)?.let { coinId ->
            getCoin(coinId)
        }
    }


    private fun getCoin(coinId: String) {
        coinUseCases.getCoinById(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value =  CoinDetailState(error = result.error ?: "Unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }
            .launchIn(viewModelScope)

    }
}