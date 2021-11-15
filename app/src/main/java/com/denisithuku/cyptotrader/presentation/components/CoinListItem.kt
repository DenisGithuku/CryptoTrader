package com.denisithuku.cyptotrader.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.denisithuku.cyptotrader.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onItemClick(coin)
            }
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.weight(8f)
        )
        Text(
            text = if (coin.is_active) "active" else "not active",
            color = if (coin.is_active) Green else Red,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.align(CenterVertically).weight(2f)
        )
    }

}