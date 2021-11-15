package com.denisithuku.cyptotrader.presentation.util

import com.denisithuku.cyptotrader.domain.model.CoinDetail

data class CoinDetailState (
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
