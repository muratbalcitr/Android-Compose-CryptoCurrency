package com.m2lifeapps.cryptocurrenywithcompose.di

import com.m2lifeapps.cryptocurrenywithcompose.common.Constants.BASE_URL
import com.m2lifeapps.cryptocurrenywithcompose.data.remote.CoinPaprikaApi
import com.m2lifeapps.cryptocurrenywithcompose.domain.model.CoinRepositoryImpl
import com.m2lifeapps.cryptocurrenywithcompose.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}
