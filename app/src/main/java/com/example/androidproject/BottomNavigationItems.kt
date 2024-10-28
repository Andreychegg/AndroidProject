package com.example.androidproject

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItems(
    val route: String,
    val title: String? = null,
    val icon: ImageVector? = null
) {
    object  Home: BottomNavigationItems(
        route = "Home",
        title = "Home",
        icon = Icons.Outlined.Home
    )
    object  ItemsList: BottomNavigationItems(
        route = "Список",
        title = "Список",
        icon = Icons.AutoMirrored.Outlined.List
    )
    object  Screen2: BottomNavigationItems(
        route = "screen2",
        title = "Screen2",
        icon = Icons.Outlined.Notifications
    )
    object  Screen3: BottomNavigationItems(
        route = "screen3",
        title = "Screen3",
        icon = Icons.Outlined.AccountCircle
    )
}