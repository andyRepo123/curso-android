package com.example.apprendevcurso

import android.app.Application
import com.example.apprendevcurso.catalogo.injector.MoviesInjector

class Movies : Application() {
    private lateinit var moviesInjector: MoviesInjector
    override fun onCreate() {
        super.onCreate()
        moviesInjector = MoviesInjector()
    }
}