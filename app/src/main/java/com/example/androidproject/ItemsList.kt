package com.example.androidproject

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ItemsList(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(40) { index ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)
                    .padding(horizontal = 15.dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 15.dp)
                    .clickable { navController.navigate("itemInfo/$index") },
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Фильм $index",
                    fontSize = 22.sp)
            }
        }
    }
}