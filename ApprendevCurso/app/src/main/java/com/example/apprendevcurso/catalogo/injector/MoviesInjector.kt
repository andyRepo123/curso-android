package com.example.apprendevcurso.catalogo.injector

import com.example.apprendevcurso.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MoviesInjector {
    private lateinit var client: OkHttpClient

    private fun buildHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(120000, TimeUnit.MILLISECONDS)
        builder.readTimeout(120000, TimeUnit.MILLISECONDS)
        return builder.build().also { client = it }
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.THEMOVIE)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(buildHttpClient())
            .build()
    }
}