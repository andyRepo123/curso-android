package com.example.apprendevcurso.spinnersamples.ui.spinner

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.apprendevcurso.R
import com.example.apprendevcurso.databinding.SpinnerFragmentBinding

class SpinnerFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: SpinnerFragmentBinding
    private lateinit var viewModel: SpinnerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = with(SpinnerFragmentBinding.inflate(inflater, container, false)) {
        binding = this
        binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpComponents()
    }

    fun setUpComponents() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.soccer_players,
            android.R.layout.simple_spinner_item
        ).also { playerSoccerAdapter ->
            playerSoccerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerPlayers.adapter = playerSoccerAdapter
            binding.spinnerPlayers.onItemSelectedListener = this
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpinnerViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.d(
            SpinnerFragment::class.java.simpleName,
            "onItemSelected() called with: parent = $parent, view = $view, position = $position, id = $id"
        )
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Log.d(
            SpinnerFragment::class.java.simpleName,
            "onNothingSelected() called with: parent = $parent"
        )
    }

}