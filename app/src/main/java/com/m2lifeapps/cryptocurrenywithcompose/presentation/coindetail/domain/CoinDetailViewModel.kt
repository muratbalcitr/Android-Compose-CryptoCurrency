package com.m2lifeapps.cryptocurrenywithcompose.presentation.coindetail.domain

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.m2lifeapps.cryptocurrenywithcompose.common.Constants
import com.m2lifeapps.cryptocurrenywithcompose.common.Resource
import com.m2lifeapps.cryptocurrenywithcompose.presentation.coinlist.domain.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    val useCase: CoinDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state
init {
    savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId->
        getCoinById(coinId)
    }
}

    private fun getCoinById(coinId:String) {
        useCase.getCoinById(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    result.let { res ->
                        _state.value = CoinDetailState(false, res.data)
                    }
                }
                is Resource.Error -> {
                    result.let { res ->
                        _state.value = CoinDetailState(error = res.message ?: "Opps")
                    }
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
