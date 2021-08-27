package com.example.apprendevcurso.catalogo.factory

import com.example.apprendevcurso.catalogo.data.MoviesServices
import com.example.apprendevcurso.catalogo.domain.GetTopRatedUseCase

interface MoviesFactory {
    fun getTopRatedUseCase(): GetTopRatedUseCase

    class Builder(
        private val services: MoviesServices
    ) {
        fun build(): MoviesFactory = MoviesFactoryImpl(services)
    }
}