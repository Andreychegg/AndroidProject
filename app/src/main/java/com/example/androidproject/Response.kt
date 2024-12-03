package com.example.androidproject

data class MovieResponse(
    val data: MovieData
)

data class MovieData(
    val title: Movie
)

data class Movie(
    val id: String,
    val type: String,
    val start_year: Int,
    val plot: String,
    val primary_title: String,
    val genres: List<String>,
    val posters: List<Poster>?,
    val rating: Rating
)

data class Rating(
    val aggregate_rating: Float,
    val votes_count: Int
)

data class Poster(
    val url: String,
    val width: Int,
    val height: Int
)