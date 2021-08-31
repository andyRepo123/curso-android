package com.example.apprendevcurso.tablayoutsamples.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.apprendevcurso.R
import com.example.apprendevcurso.databinding.SpinnerTeamSoccerBinding
import com.example.apprendevcurso.tablayoutsamples.model.TeamSoccer
import com.squareup.picasso.Picasso

class SoccerAdapter(val context: Context, var soccers: List<TeamSoccer>) : BaseAdapter() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = soccers.size

    override fun getItem(position: Int): TeamSoccer = soccers[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val soccerHolder: SoccerHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.spinner_team_soccer, parent, false)
            soccerHolder = SoccerHolder(SpinnerTeamSoccerBinding.bind(view), soccers[position])
            view.tag = soccerHolder
        } else {
            view = convertView
        }
        return view
    }
}

class SoccerHolder(binding: SpinnerTeamSoccerBinding, teamSoccer: TeamSoccer) {
    init {
        binding.teamName.text = teamSoccer.name
        Picasso.with(binding.root.context)
            .load(teamSoccer.image)
            .error(R.drawable.ic_launcher_background)
            .into(binding.imageTeam)
    }
}