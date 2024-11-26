package com.example.androidproject

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost

@Composable
fun NavigationGraph(navController: NavHostController, movieViewModel: MovieViewModel) {
    NavHost(
        navController = navController,
        startDestination = "itemsList"
    ) {
        composable("itemsList") {
            ItemsList(navController = navController, movieViewModel = movieViewModel)
        }
        composable("itemInfo/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId") ?: ""
            ItemInfo(movieId = movieId, movieViewModel = movieViewModel)
        }
    }
}