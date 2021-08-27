package com.example.apprendevcurso.catalogo.data

import com.example.apprendevcurso.catalogo.data.api.entities.gettoprated.GetTopRatedResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesServices {
    @GET("movie/top_rated")
    fun getTopRated(
        @Query("page")
        page: Int,
        @Query("api_key")
        key: String
    ): Single<GetTopRatedResponse>
}