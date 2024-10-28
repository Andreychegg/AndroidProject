package com.example.androidproject

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.ItemsList.route) {
        composable(BottomNavigationItems.ItemsList.route) {
            ItemsList(navController = navController)
        }
        composable(BottomNavigationItems.Home.route) {
            Home()
        }
        composable(BottomNavigationItems.Screen2.route) {
            Screen2()
        }
        composable(BottomNavigationItems.Screen3.route) {
            Screen3()
        }
        composable("itemInfo/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")?.toInt() ?: 0
            ItemInfo(itemId = itemId)
        }
    }
}