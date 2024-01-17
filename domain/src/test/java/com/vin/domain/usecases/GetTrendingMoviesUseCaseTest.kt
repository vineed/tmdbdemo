package com.vin.domain.usecases

import com.vin.domain.data_provider.DataProvider
import com.vin.domain.entities.Movie
import com.vin.domain.exception.GenericException
import com.vin.domain.repositories.MovieRepository
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.`when`


class GetTrendingMoviesUseCaseTest {
    private lateinit var SUT: GetTrendingMoviesUseCase
    private var isFailure = false

    @Before
    public fun setup() {
        SUT = GetTrendingMoviesUseCase(MoveRepositoryTD())
    }

    @Test
    //success get trending movies data
    fun fetchTrendingMovies_success_getMoviesData(){
        //Arrange
        val successTrendingMovieList = DataProvider.getSuccessTrendingMovies()

        //Act
        val trendingMoviesList = SUT.execute()

        //Assert
        assertThat(trendingMoviesList, `is`(successTrendingMovieList))
    }

    //failure returns failure result
    @Test(expected = GenericException.NetworkError::class)
    fun fetchTrendingMovie_failure_returnFailure(){
        //Arrange
        failureCase()

        //ACT
        SUT.execute()

        //ASSERT
    }
    //

    //utilities
    private fun failureCase() {
        isFailure = true
    }

    //TD
    inner class MoveRepositoryTD: MovieRepository {
        override fun getTrendingMovies(): List<Movie> {
            if(isFailure) throw GenericException.NetworkError

            return DataProvider.getSuccessTrendingMovies()
        }

    }

    //END TD
}