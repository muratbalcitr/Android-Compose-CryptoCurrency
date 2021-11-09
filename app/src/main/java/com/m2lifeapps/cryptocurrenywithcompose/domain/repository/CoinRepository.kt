package com.m2lifeapps.cryptocurrenywithcompose.domain.repository

import com.m2lifeapps.cryptocurrenywithcompose.data.remote.dto.CoinDetailResponse
import com.m2lifeapps.cryptocurrenywithcompose.data.remote.dto.CoinResponse

  interface CoinRepository {
    suspend fun getCoins(): List<CoinResponse>
    suspend fun getCoinById(coinId: String): CoinDetailResponse
}
