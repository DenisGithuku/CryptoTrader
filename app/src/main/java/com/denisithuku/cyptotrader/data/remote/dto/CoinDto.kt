package com.denisithuku.cyptotrader.data.remote.dto

import com.denisithuku.cyptotrader.domain.model.Coin

data class CoinsDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinsDto.toCoin(): Coin {
    return Coin (
        id = id,
        is_active = is_active,
        is_new = is_new,
        name = name,
        rank = rank,
        symbol = symbol,
        type = type
            )
}