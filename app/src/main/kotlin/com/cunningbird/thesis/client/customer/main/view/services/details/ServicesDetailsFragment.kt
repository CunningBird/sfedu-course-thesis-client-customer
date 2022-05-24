package com.cunningbird.thesis.client.customer.main.view.services.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cunningbird.thesis.client.customer.R
import com.cunningbird.thesis.client.customer.databinding.FragmentServicesDetailsBinding
import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import com.cunningbird.thesis.client.customer.main.domain.repository.ServiceRepository
import com.cunningbird.thesis.client.customer.main.view.FragmentViewModelFactory
import com.cunningbird.thesis.client.customer.main.view.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

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

    private lateinit var service: Service

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

        val id = UUID.fromString(arguments!!.get("serviceId") as String)

        viewModel.getServiceById(id).enqueue(object : Callback<Service> {
            override fun onFailure(call: Call<Service>, t: Throwable) {
                Log.d("MainActivity", "Request Failed: $call")
            }

            override fun onResponse(call: Call<Service>, response: Response<Service>) {
                val service = response.body()

                if (!response.isSuccessful || service == null) {
                    Log.d("MainActivity", "Request Failed: $call")
                } else {
                    Log.d("MainActivity", "Request Success")
                    binding.tvServiceName.text = service.title
                    binding.tvServiceAmount.text = service.price.toString()
                    binding.tvServiceDescription.text = service.description
                }
            }
        })
        setListeners()
        setViews()
    }

    private fun setViews() {
        mainActivity.changeToolbar(getString(R.string.service_details), true)
    }

    private fun setListeners() {
        binding.actionButton.setOnClickListener {
            // TODO Send POST to appoint
//            val arg = bundleOf(
//                "title" to binding.tvServiceName.text.toString(),
//                "price" to binding.tvServiceAmount.text.toString()
//            )
//            findNavController().navigate(
//                R.id.action_servicesDetailsFragment_to_servicesAppointFragment,
//                arg
//            )
        }
    }
}