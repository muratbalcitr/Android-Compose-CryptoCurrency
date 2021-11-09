package com.m2lifeapps.cryptocurrenywithcompose.presentation.coindetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.m2lifeapps.cryptocurrenywithcompose.data.remote.dto.CoinDetailResponse

@Composable
fun TeamListItem(
    teamMember: CoinDetailResponse.Team,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMember.name,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.position,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
    }
}
