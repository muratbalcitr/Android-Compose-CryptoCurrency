package com.m2lifeapps.cryptocurrenywithcompose.presentation.coinlist.domain

import com.m2lifeapps.cryptocurrenywithcompose.common.Resource
import com.m2lifeapps.cryptocurrenywithcompose.data.remote.dto.CoinResponse
import com.m2lifeapps.cryptocurrenywithcompose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinListUseCase @Inject constructor(
    val repository: CoinRepository
) {
    fun getCoins(): Flow<Resource<List<CoinResponse>>> {
        return flow {
            try {
                emit(Resource.Loading<List<CoinResponse>>())
                val coins = repository.getCoins()
                emit(Resource.Success<List<CoinResponse>>(coins))
            } catch (e: HttpException) {
                emit(Resource.Error<List<CoinResponse>>(e.localizedMessage ?: "An Unexpected error occured"))
            } catch (e: IOException) {
                emit(Resource.Error<List<CoinResponse>>("Check Your Internet Connection"))
            }
        }
    }
}
