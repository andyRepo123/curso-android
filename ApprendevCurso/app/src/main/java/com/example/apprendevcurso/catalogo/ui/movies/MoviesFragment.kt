package com.example.apprendevcurso.catalogo.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apprendevcurso.catalogo.factory.HasMoviesFactory
import com.example.apprendevcurso.catalogo.factory.MoviesFactoryImpl
import com.example.apprendevcurso.catalogo.ui.movies.adapters.MoviesAdapter
import com.example.apprendevcurso.catalogo.ui.movies.viewstate.MoviesState
import com.example.apprendevcurso.databinding.MoviesFragmentBinding

class MoviesFragment : Fragment() {
    private lateinit var viewModel: MoviesViewModel
    private lateinit var binding: MoviesFragmentBinding
    private val moviesAdapter: MoviesAdapter by lazy {
        MoviesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = with(MoviesFragmentBinding.inflate(inflater, container, false)) {
        binding = this
        binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservable()
    }

    fun setUpObservable() {
        viewModel = ViewModelProvider(this, moviesFactory).get(MoviesViewModel::class.java)
        viewModel.videosState.observe(viewLifecycleOwner) {
            when (it) {
                is MoviesState.Loading -> {
                    Log.d(MoviesFragment::class.java.simpleName, "setUpObservable() Loading")
                }
                is MoviesState.MovieSuccessfully -> {
                    moviesAdapter.submitList(it.videos)
                    moviesAdapter.notifyDataSetChanged()
                    if (binding.topRatedVideos.adapter == null) {
                        binding.topRatedVideos.adapter = moviesAdapter
                    }
                }
                is MoviesState.MovieError -> {
                    Log.d(MoviesFragment::class.java.simpleName, "setUpObservable() MovieError")
                }
            }
        }
        viewModel.getTopRated("1")
    }

    private val moviesFactory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            val factory: MoviesFactoryImpl =
                (requireActivity().application as HasMoviesFactory).getMoviesFactory() as MoviesFactoryImpl
            return factory.getMoviesViewModel() as T
        }
    }
}