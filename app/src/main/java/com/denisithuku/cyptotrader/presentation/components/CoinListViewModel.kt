package com.denisithuku.cyptotrader.presentation.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denisithuku.cyptotrader.presentation.util.CoinScreenState
import com.denisithuku.cyptotrader.common.Resource
import com.denisithuku.cyptotrader.domain.use_cases.CoinUseCases
import com.denisithuku.cyptotrader.common.CoroutineDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinUseCases: CoinUseCases,
    private val coroutineDispatchers: CoroutineDispatchers
) : ViewModel() {

    private val _state = mutableStateOf(CoinScreenState())
    val state: State<CoinScreenState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
            coinUseCases.getAllCoins().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = CoinScreenState(coins = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _state.value = CoinScreenState(error = result.error ?: "An error occurred")
                    }
                    is Resource.Loading -> {
                        _state.value = CoinScreenState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }