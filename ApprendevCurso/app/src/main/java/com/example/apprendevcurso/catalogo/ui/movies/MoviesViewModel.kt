package com.example.apprendevcurso.catalogo.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apprendevcurso.catalogo.domain.GetTopRatedUseCase
import com.example.apprendevcurso.catalogo.shared.data.VideoEntity
import com.example.apprendevcurso.catalogo.ui.movies.viewdata.MovieViewData
import com.example.apprendevcurso.catalogo.ui.movies.viewstate.MoviesState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MoviesViewModel(
    private val getTopRatedUseCase: GetTopRatedUseCase
) : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val _videosState = MutableLiveData<MoviesState>()
    val videosState = _videosState as LiveData<MoviesState>

    fun getTopRated(page: String) = compositeDisposable.add(
        getTopRatedUseCase.invoke(page)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(
                { videos ->
                    _videosState.postValue(
                        MoviesState
                            .MovieSuccessfully(
                                videos
                                    .map {
                                        it.toMovieViewData()
                                    })
                    )
                },
                {
                    _videosState.postValue(MoviesState.MovieError(it))
                }
            )
    )

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    private fun VideoEntity.toMovieViewData() = MovieViewData(
        title = this.title,
        description = this.description
    )
}
