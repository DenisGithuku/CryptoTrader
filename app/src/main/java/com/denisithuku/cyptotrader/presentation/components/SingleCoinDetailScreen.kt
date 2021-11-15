package com.denisithuku.cyptotrader.presentation.components

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment

@Composable
fun SingleCoinDetailScreen(
    coinDetailViewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = coinDetailViewModel.state.value
    val scrollState = rememberScrollState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .scrollable(
                    state = scrollState,
                    orientation = Orientation.Vertical,
                    enabled = true
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Text(
                    text = "${state.coin?.rank}. ${state.coin?.name}",
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(8f)
                )
                Text(
                    text = if (state.coin?.isActive == true) "active" else "not active",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.weight(2f)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                mainAxisAlignment = MainAxisAlignment.Start,
                crossAxisAlignment = FlowCrossAxisAlignment.Center,
                mainAxisSpacing = 4.dp,
                crossAxisSpacing = 4.dp
            ) {
                state.coin?.tags?.forEach { tag ->
                    CoinTag(tag = tag)
                }
            }

            state.coin?.team?.forEach { teamMember ->
                TeamMember(teamMember = teamMember)
                Divider(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }

        }
    }
}