package com.m2lifeapps.cryptocurrenywithcompose.presentation.coinlist.domain

import com.m2lifeapps.cryptocurrenywithcompose.data.remote.dto.CoinResponse

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinResponse> = emptyList(),
    val error: String = ""
)
