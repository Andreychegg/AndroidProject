package com.example.androidproject

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface IMDbApi {
    @Headers("Content-Type: application/json")
    @POST("v1")
    suspend fun getMovieInfo(@Body requestBody: Map<String, String>): MovieResponse
}