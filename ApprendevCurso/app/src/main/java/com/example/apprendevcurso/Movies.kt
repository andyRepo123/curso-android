package com.example.apprendevcurso

import android.app.Application
import com.example.apprendevcurso.catalogo.factory.HasMoviesFactory
import com.example.apprendevcurso.catalogo.factory.MoviesFactory
import com.example.apprendevcurso.catalogo.injector.MoviesInjector

class Movies : Application(), HasMoviesFactory {
    private lateinit var moviesInjector: MoviesInjector
    private lateinit var moviesFactory: MoviesFactory
    override fun onCreate() {
        super.onCreate()
        moviesInjector = MoviesInjector()
    }

    override fun getMoviesFactory(): MoviesFactory {
        moviesFactory = MoviesFactory.Builder(moviesInjector.moviesServices).build()
        return moviesFactory
    }
}