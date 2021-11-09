package com.m2lifeapps.cryptocurrenywithcompose.presentation.coindetail.domain

import com.m2lifeapps.cryptocurrenywithcompose.common.Resource
import com.m2lifeapps.cryptocurrenywithcompose.data.remote.dto.CoinDetailResponse
import com.m2lifeapps.cryptocurrenywithcompose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinDetailUseCase @Inject constructor(
    val repository: CoinRepository
) {

    fun getCoinById(coinId: String): Flow<Resource<CoinDetailResponse>> {
        return flow {
            try {
                emit(Resource.Loading<CoinDetailResponse>())
                val coins = repository.getCoinById(coinId)
                emit(Resource.Success<CoinDetailResponse>(coins))
            } catch (e: HttpException) {
                emit(Resource.Error<CoinDetailResponse>(e.localizedMessage ?: "An Unexpected error occured"))
            } catch (e: IOException) {
                emit(Resource.Error<CoinDetailResponse>("Check Your Internet Connection"))
            }
        }
    }
}
