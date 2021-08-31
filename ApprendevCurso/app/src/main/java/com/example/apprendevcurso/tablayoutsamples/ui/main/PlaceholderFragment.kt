package com.example.apprendevcurso.tablayoutsamples.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.apprendevcurso.databinding.FragmentPlayersBinding
import com.example.apprendevcurso.tablayoutsamples.model.TeamSoccer
import com.example.apprendevcurso.tablayoutsamples.ui.main.adapters.SoccerAdapter

class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private lateinit var binding: FragmentPlayersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = with(FragmentPlayersBinding::class.simpleName) {
        binding = FragmentPlayersBinding.inflate(inflater, container, false)
        binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpComponent()
    }

    private fun setUpComponent() {
        val teamSoccers: List<TeamSoccer> = listOf(
            TeamSoccer("PSG", "https://c8.alamy.com/compes/t3errd/cerca-de-paris-saint-germain-jersey-t3errd.jpg"),
            TeamSoccer("ManCity", "https://pbs.twimg.com/profile_images/1339132856048742400/Ky0fi4Nm.jpg")
        )
        val soccerAdapter = SoccerAdapter(requireContext(), teamSoccers)
        binding.spinnerSoccers.adapter = soccerAdapter
    }
}