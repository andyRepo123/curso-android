package com.example.apprendevcurso.catalogo.data.api.entities.gettoprated

import com.google.gson.annotations.SerializedName

data class GetTopRatedResponse(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("total_page")
    val totalPage: Int? = 0,
    @SerializedName("total_results")
    val totalResult: Int? = 0,
    @SerializedName("results")
    val results: List<ResultsItem>
)