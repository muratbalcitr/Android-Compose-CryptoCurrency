package com.m2lifeapps.cryptocurrenywithcompose.presentation.coinlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.m2lifeapps.cryptocurrenywithcompose.data.remote.dto.CoinResponse

@Composable
fun CoinListItem(
    coin: CoinResponse,
    onItemClick: (CoinResponse) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .clickable { onItemClick(coin) }
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = if (coin.isActive) "active" else "inactive",
            color = if (coin.isActive) Color.Green else Color.LightGray,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}
