package com.m2lifeapps.cryptocurrenywithcompose.presentation.coindetail.domain

import com.m2lifeapps.cryptocurrenywithcompose.data.remote.dto.CoinDetailResponse

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coins: CoinDetailResponse? = null,
    val error: String = ""
)
