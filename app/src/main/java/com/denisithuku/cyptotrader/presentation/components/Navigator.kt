package com.denisithuku.cyptotrader.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.denisithuku.cyptotrader.common.Constants
import com.denisithuku.cyptotrader.presentation.util.Screen

@Composable
fun Navigator() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = Screen.CoinListScreen.route) {
        composable(
            Screen.CoinListScreen.route,
        ) {
            MainCoinListScreen(navController = navHostController)
        }
        composable(Screen.CoinDetailScreen.route + "/{coinId}") {
            SingleCoinDetailScreen()
        }
    }
}