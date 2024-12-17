package com.example.composecrash.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composecrash.ui.screen.HomeScreen

@Composable
fun AppNavigationGraph() {
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {
         composable(Routes.HOME_SCREEN) { HomeScreen() }
    }

}