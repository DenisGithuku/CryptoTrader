package com.denisithuku.cyptotrader.presentation.util

import com.denisithuku.cyptotrader.domain.model.Coin
import com.denisithuku.cyptotrader.domain.model.CoinDetail

data class CoinScreenState(
    val coins: List<Coin> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
