package com.example.androidproject

class GetMovieDetailsUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(movieId: String): Movie {
        return repository.getMovieDetails(movieId)
    }
}