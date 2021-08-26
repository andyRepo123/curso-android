package com.example.apprendevcurso.catalogo.domain

import com.example.apprendevcurso.catalogo.shared.data.VideoEntity
import com.example.apprendevcurso.catalogo.shared.data.api.MoviesApi
import io.reactivex.Single

class GetTopRatedUseCase(private val moviesApi: MoviesApi) {
    operator fun invoke(page: String): Single<List<VideoEntity>> =
        moviesApi.getTopRated(page)
}