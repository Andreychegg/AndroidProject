package com.example.androidproject

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.sp

@Composable
fun ItemInfo(movieId: String, movieViewModel: MovieViewModel) {
    val movieResult = movieViewModel.getMovieDetails(movieId).observeAsState()

    movieResult.value?.let { result ->
        if (result.isSuccess) {
            val movieDetails = result.getOrNull()
            if (movieDetails != null) {
                Text(text = movieDetails.plot, fontSize = 16.sp)
            } else {
                Text(text = "Информация о фильме недоступна", fontSize = 16.sp)
            }
        } else if (result.isFailure) {
            Text(text = "Ошибка загрузки данных: ${result.exceptionOrNull()?.message}", fontSize = 16.sp)
        }
    }
}