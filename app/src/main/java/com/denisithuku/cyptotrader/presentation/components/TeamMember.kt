package com.denisithuku.cyptotrader.presentation.components

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.denisithuku.cyptotrader.data.remote.dto.TeamMember

@Composable
fun TeamMember(
    teamMember: TeamMember
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Text(text = teamMember.name, fontWeight = FontWeight.Bold)
        Text(text = teamMember.position, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
}