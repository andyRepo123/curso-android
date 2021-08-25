package com.example.apprendevcurso.bottomnavigationsample.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.apprendevcurso.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = with(FragmentDashboardBinding.inflate(inflater, container, false)) {
        binding = this
        binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewModel()
        setUp()
    }

    private fun initializeViewModel() {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
    }

    private fun setUp() = with(binding) {
        dashboardViewModel.text.observe(viewLifecycleOwner) { dashboard ->
            textDashboard.text = dashboard
        }
    }
}