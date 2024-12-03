package com.example.androidproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidproject.ui.theme.AndroidProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProjectTheme {
                val navController: NavHostController = rememberNavController()

                val imdbApi = RetrofitInstance.imdbApi
                val repository = MovieRepository(imdbApi)
                val getMovieDetailsUseCase = GetMovieDetailsUseCase(repository)
                val movieViewModel: MovieViewModel = viewModel {
                    MovieViewModel(getMovieDetailsUseCase)
                }

                Scaffold(
                    bottomBar = {
                        BottomBar(
                            navController = navController,
                            state = true,
                            modifier = Modifier
                        )
                    }
                ) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        NavigationGraph(navController = navController, movieViewModel = movieViewModel)
                    }
                }
            }
        }
    }
}
