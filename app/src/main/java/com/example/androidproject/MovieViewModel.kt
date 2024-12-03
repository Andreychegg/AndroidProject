package com.example.androidproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MovieViewModel(private val getMovieDetailsUseCase: GetMovieDetailsUseCase) : ViewModel() {

    fun getMovieDetails(movieId: String) = liveData(Dispatchers.IO) {
        try {
            val movie = getMovieDetailsUseCase(movieId)
            emit(Result.success(movie))
        } catch (e: Exception) {
            emit(Result.failure<Movie>(e))
        }
    }
}