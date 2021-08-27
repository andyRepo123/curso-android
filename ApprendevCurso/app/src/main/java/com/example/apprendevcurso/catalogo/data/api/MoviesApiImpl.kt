package com.example.apprendevcurso.catalogo.data.api

import com.example.apprendevcurso.BuildConfig
import com.example.apprendevcurso.catalogo.data.MoviesServices
import com.example.apprendevcurso.catalogo.data.api.entities.gettoprated.ResultsItem
import com.example.apprendevcurso.catalogo.shared.data.VideoEntity
import com.example.apprendevcurso.catalogo.shared.data.api.MoviesApi
import io.reactivex.Single

class MoviesApiImpl(private val moviesServices: MoviesServices) : MoviesApi {
    override fun getTopRated(page: String): Single<List<VideoEntity>> =
        moviesServices.getTopRated(page.toInt(), BuildConfig.APIKEY).map { getTopRatedResponse ->
            return@map getTopRatedResponse
                .results
                .map {
                    it.toVideoEntity()
                }
        }
}

private fun ResultsItem.toVideoEntity() = VideoEntity(
    title = this.title ?: "",
    description = this.overview ?: ""
)
