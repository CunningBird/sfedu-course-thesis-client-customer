package com.cunningbird.thesis.client.customer.main.view.appointments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cunningbird.thesis.client.customer.databinding.FragmentAppointmentsDetailsBinding

class AppointmentsDetailsFragment : Fragment() {
    private lateinit var binding: FragmentAppointmentsDetailsBinding
    val viewModel: AppointmentsDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAppointmentsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setViews()
    }

    private fun setViews() {

    }

    private fun setListeners() {

    }
}