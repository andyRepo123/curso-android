package com.example.apprendevcurso.catalogo.factory

import com.example.apprendevcurso.catalogo.data.MoviesServices
import com.example.apprendevcurso.catalogo.data.api.MoviesApiImpl
import com.example.apprendevcurso.catalogo.domain.GetTopRatedUseCase
import com.example.apprendevcurso.catalogo.shared.data.api.MoviesApi
import com.example.apprendevcurso.catalogo.ui.movies.MoviesViewModel

internal class MoviesFactoryImpl(
    private val moviesServices: MoviesServices
) : MoviesFactory {
    fun getMoviesViewModel(): MoviesViewModel = MoviesViewModel(getTopRatedUseCase())

    override fun getTopRatedUseCase(): GetTopRatedUseCase = GetTopRatedUseCase(getMoviesApi())

    private fun getMoviesApi(): MoviesApi = MoviesApiImpl(moviesServices)
}