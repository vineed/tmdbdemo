package com.vin.domain.data_provider

import com.vin.domain.entities.Movie

object DataProvider {
    fun getSuccessTrendingMovies(): List<Movie> {
        return listOf(
            Movie("1", "Test Movie1", "Test description 1", "http://example.com/1.jpg"),
            Movie("2", "Test Movie2", "Test description 2", "http://example.com/2.jpg"),
        )
    }
}