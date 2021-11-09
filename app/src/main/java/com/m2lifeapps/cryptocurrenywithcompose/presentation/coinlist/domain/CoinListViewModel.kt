package com.m2lifeapps.cryptocurrenywithcompose.presentation.coinlist.domain

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.m2lifeapps.cryptocurrenywithcompose.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    val useCase: CoinListUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }
    private fun getCoins() {
        useCase.getCoins().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    result.let { res ->
                        _state.value = res.data?.let { CoinListState(false, it) }!!
                    }
                }
                is Resource.Error -> {
                    result.let { res ->
                        _state.value = CoinListState(error = res.message ?: "Opps")
                    }
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
