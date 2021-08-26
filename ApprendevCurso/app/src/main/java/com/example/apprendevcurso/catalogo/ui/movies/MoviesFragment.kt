package com.example.apprendevcurso.catalogo.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.apprendevcurso.catalogo.ui.movies.viewstate.MoviesState
import com.example.apprendevcurso.databinding.MoviesFragmentBinding

class MoviesFragment : Fragment() {
    private lateinit var viewModel: MoviesViewModel
    private lateinit var binding: MoviesFragmentBinding

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
        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        /*viewModel.videosState.observe(viewLifecycleOwner) {
            when (it) {
                is MoviesState.Loading -> {
                }
                is MoviesState.MovieSuccessfully -> {
                }
                is MoviesState.MovieError -> {
                }
            }
        }*/
    }
}