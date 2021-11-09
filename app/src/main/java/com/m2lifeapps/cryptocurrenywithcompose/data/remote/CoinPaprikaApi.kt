package com.m2lifeapps.cryptocurrenywithcompose.data.remote

import com.m2lifeapps.cryptocurrenywithcompose.data.remote.dto.CoinDetailResponse
import com.m2lifeapps.cryptocurrenywithcompose.data.remote.dto.CoinResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinResponse>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailResponse
}
