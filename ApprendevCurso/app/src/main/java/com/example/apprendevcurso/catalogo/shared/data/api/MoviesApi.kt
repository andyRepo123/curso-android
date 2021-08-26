package com.example.apprendevcurso.catalogo.shared.data.api

import com.example.apprendevcurso.catalogo.shared.data.VideoEntity
import io.reactivex.Single

interface MoviesApi {
    fun getTopRated(page: String): Single<List<VideoEntity>>
}