package com.cunningbird.thesis.client.customer.main.view.services.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cunningbird.thesis.client.customer.R
import com.cunningbird.thesis.client.customer.databinding.FragmentServicesDetailsBinding
import com.cunningbird.thesis.client.customer.main.domain.repository.ServiceRepository
import com.cunningbird.thesis.client.customer.main.view.FragmentViewModelFactory
import com.cunningbird.thesis.client.customer.main.view.MainActivity
import com.cunningbird.thesis.client.customer.main.view.services.detail.ServicesDetailsViewModel

class ServicesDetailsFragment : Fragment() {

    private lateinit var binding: FragmentServicesDetailsBinding

    val viewModel: ServicesDetailsViewModel by viewModels {
        FragmentViewModelFactory(
            mainActivity.application,
            mainActivity.viewModel.serviceRepository,
            ServiceRepository::class.java
        )
    }

    private lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivity = (activity as MainActivity)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentServicesDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setViews()
    }

    private fun setViews() {
        mainActivity.changeToolbar(getString(R.string.service_details), true)
    }

    private fun setListeners() {
        binding.actionButton.setOnClickListener {
            val arg = bundleOf(
                "title" to binding.tvServiceName.text.toString(),
                "price" to binding.tvServiceAmount.text.toString()
            )
            findNavController().navigate(
                R.id.action_servicesDetailsFragment_to_servicesAppointFragment,
                arg
            )
        }
    }
}