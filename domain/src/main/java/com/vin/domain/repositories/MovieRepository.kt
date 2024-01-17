package com.vin.domain.repositories

import com.vin.domain.entities.Movie

interface MovieRepository {
    fun getTrendingMovies(): List<Movie>

}
