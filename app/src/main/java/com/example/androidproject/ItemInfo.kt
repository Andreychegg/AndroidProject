package com.example.androidproject

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage

@Composable
fun ItemInfo(movieId: String, movieViewModel: MovieViewModel) {
    val movieResult = movieViewModel.getMovieDetails(movieId).observeAsState()

    movieResult.value?.let { result ->
        if (result.isSuccess) {
            val movieDetails = result.getOrNull()
            if (movieDetails != null) {
                val posterUrl = movieDetails.posters?.firstOrNull()?.url
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    val (poster, genresYearRating, title, plot) = createRefs()

                    AsyncImage(
                        model = posterUrl,
                        contentDescription = "Постер фильма",
                        modifier = Modifier
                            .constrainAs(poster) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                            }
                            .size(250.dp),
                    )

                    Text(
                        text = buildString {
                            append("Жанры: ${movieDetails.genres.joinToString(", ")}\n")
                            append("Год выхода: ${movieDetails.start_year}\n")
                            append("Рейтинг: ${movieDetails.rating.aggregate_rating}")
                        },
                        fontSize = 16.sp,
                        modifier = Modifier
                            .constrainAs(genresYearRating) {
                                top.linkTo(poster.top)
                                start.linkTo(poster.end, margin = 8.dp)
                                end.linkTo(parent.end)
                                width = androidx.constraintlayout.compose.Dimension.fillToConstraints
                            }
                    )

                    Text(
                        text = movieDetails.primary_title,
                        fontSize = 24.sp,
                        modifier = Modifier
                            .constrainAs(title) {
                                top.linkTo(poster.bottom, margin = 16.dp)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    )

                    Text(
                        text = movieDetails.plot,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .constrainAs(plot) {
                                top.linkTo(title.bottom, margin = 16.dp)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    )
                }
            } else {
                Text(text = "Информация о фильме недоступна", fontSize = 16.sp)
            }
        } else if (result.isFailure) {
            Text(text = "Ошибка загрузки данных: ${result.exceptionOrNull()?.message}", fontSize = 16.sp)
        }
    }
}