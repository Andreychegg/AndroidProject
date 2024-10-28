package com.example.androidproject

sealed class Routes(val route: String) {
    object ItemsList : Routes("Список")
    object Home : Routes("Home")
    object Screen2 : Routes("screen2")
    object Screen3 : Routes("screen3")
}