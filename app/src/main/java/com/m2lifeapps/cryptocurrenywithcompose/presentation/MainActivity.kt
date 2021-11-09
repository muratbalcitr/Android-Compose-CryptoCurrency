package com.m2lifeapps.cryptocurrenywithcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.m2lifeapps.cryptocurrenywithcompose.presentation.coindetail.CoinDetailScreen
import com.m2lifeapps.cryptocurrenywithcompose.presentation.coinlist.CoinListScreen
import com.m2lifeapps.cryptocurrenywithcompose.presentation.ui.theme.CryptoCurrenyWithComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrenyWithComposeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.CoinListScreen.route
                ) {
                    composable(route = Screen.CoinListScreen.route) {
                        CoinListScreen(navController)
                    }
                    composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
                        CoinDetailScreen()
                    }
                }
            }
        }
    }
}
