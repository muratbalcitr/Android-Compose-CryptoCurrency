package com.m2lifeapps.cryptocurrenywithcompose.domain.model

import com.m2lifeapps.cryptocurrenywithcompose.data.remote.CoinPaprikaApi
import com.m2lifeapps.cryptocurrenywithcompose.data.remote.dto.CoinDetailResponse
import com.m2lifeapps.cryptocurrenywithcompose.data.remote.dto.CoinResponse
import com.m2lifeapps.cryptocurrenywithcompose.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiService: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinResponse> {
        return apiService.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailResponse {
        return apiService.getCoinById(coinId)
    }
}
