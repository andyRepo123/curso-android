package com.example.apprendevcurso.catalogo.ui.movies.viewstate

import com.example.apprendevcurso.catalogo.ui.movies.viewdata.MovieViewData

sealed class MoviesState {
    object Loading : MoviesState()
    data class MovieSuccessfully(val videos: List<MovieViewData>) : MoviesState()
    data class MovieError(val exception: Throwable) : MoviesState()

}
