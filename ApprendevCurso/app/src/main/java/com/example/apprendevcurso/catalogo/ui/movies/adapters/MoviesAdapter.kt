package com.example.apprendevcurso.catalogo.ui.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apprendevcurso.R
import com.example.apprendevcurso.catalogo.ui.movies.viewdata.MovieViewData
import com.example.apprendevcurso.databinding.MoviesHolderBinding

class MoviesAdapter() : ListAdapter<MovieViewData, MoviesAdapter.ViewHolder>(COMPARATOR) {
    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<MovieViewData>() {
            override fun areItemsTheSame(oldItem: MovieViewData, newItem: MovieViewData): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: MovieViewData,
                newItem: MovieViewData
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movies_holder,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        with(holder.binding) {
            titleText.text = movie.title
            descriptionText.text = movie.description
        }
        holder.binding.executePendingBindings()
    }

    inner class ViewHolder(val binding: MoviesHolderBinding) : RecyclerView.ViewHolder(binding.root)
}