package com.example.androidproject

class MovieRepository(private val api: IMDbApi) {
    suspend fun getMovieDetails(movieId: String): Movie {
        val request = mapOf(
            "query" to """
                {
                  title(id: "$movieId") {
                    id
                    type
                    start_year
                    plot
                    primary_title
                    genres
                    posters {
                      url
                      width
                      height
                    }
                    rating {
                      aggregate_rating
                      votes_count
                    }
                  }
                }
            """.trimIndent()
        )
        return api.getMovieInfo(request).data.title
    }
}