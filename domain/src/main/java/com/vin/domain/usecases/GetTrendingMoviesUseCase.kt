package com.vin.domain.usecases

import com.vin.domain.entities.Movie
import com.vin.domain.repositories.MovieRepository

class GetTrendingMoviesUseCase(private val movieRepository: MovieRepository) {
    fun execute(): List<Movie> {
        val trendingMovies = movieRepository.getTrendingMovies()

        return trendingMovies
    }

}
