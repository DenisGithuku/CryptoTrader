package com.denisithuku.cyptotrader.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.denisithuku.cyptotrader.presentation.theme.BlueCyan
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinTag(
    tag: String
) {

    Box(
        modifier = Modifier
            .padding(4.dp)
            .border(
                width = 1.dp,
                color = BlueCyan,
                shape = RoundedCornerShape(100.dp)
            ),
    ) {

            Text(
                text = tag,
                modifier = Modifier.padding(8.dp),
                color = MaterialTheme.colors.primary,
            )
    }

}
