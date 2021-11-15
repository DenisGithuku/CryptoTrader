package com.denisithuku.cyptotrader.common

import kotlinx.coroutines.CoroutineDispatcher

data class CoroutineDispatchers(
    val ioDispatcher: CoroutineDispatcher,
    val defaultDispatcher: CoroutineDispatcher,
    val mainDispatcher: CoroutineDispatcher,
    val unconfinedDispatcher: CoroutineDispatcher
)
