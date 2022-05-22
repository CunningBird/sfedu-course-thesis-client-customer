package com.cunningbird.thesis.client.customer.main.view.services.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cunningbird.thesis.client.customer.R
import com.cunningbird.thesis.client.customer.databinding.FragmentServicesListBinding
import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import com.cunningbird.thesis.client.customer.main.domain.repository.ServiceRepository
import com.cunningbird.thesis.client.customer.main.view.FragmentViewModelFactory
import com.cunningbird.thesis.client.customer.main.view.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ServicesListFragment : Fragment() {

    private lateinit var binding: FragmentServicesListBinding

    val viewModel: ServicesListViewModel by viewModels {
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
        binding = FragmentServicesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (mainActivity.checkBinding()) { // TODO fix this
            mainActivity.changeToolbar(getString(R.string.your_services), false)
        }

        val adapter = ServicesListAdapter(this::onServiceClick)
        binding.rvServices.adapter = adapter

        // TODO Debug this
//        viewModel.getServices().enqueue(object : Callback<List<Service>> {
//            override fun onFailure(call: Call<List<Service>>, t: Throwable) {
//                Log.d("MainActivity", "Request Failed: $call")
//            }
//
//            override fun onResponse(call: Call<List<Service>>, response: Response<List<Service>>) {
//                val services = response.body()
//
//                if (!response.isSuccessful || services == null) {
//                    Log.d("MainActivity", "Request Failed: $call")
//                } else {
//                    Log.d("MainActivity", "Request Success")
//                    adapter.list = services
//                }
//            }
//        })
        adapter.list = services
    }

    private fun onServiceClick(i: Int) {
        val arg = bundleOf(SERVICE_POSITION to i)
        findNavController().navigate(R.id.action_servicesListFragment_to_servicesDetailsFragment, arg)
    }

    companion object {
        const val SERVICE_POSITION = "SERVICE_POSITION"
    }

    private val services = listOf(
        Service(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130003"),
            "Awesome Advert 1",
            222.33,
            "Just awesome 1",
            "https://via.placeholder.com/1200x900"
        ),
        Service(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130004"),
            "Awesome Advert 2",
            322.33,
            "Just awesome 2",
            "https://via.placeholder.com/1200x900"
        ),
        Service(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130005"),
            "Awesome Advert 3",
            422.33,
            "Just awesome 3",
            "https://via.placeholder.com/1200x900"
        ),
        Service(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130006"),
            "Awesome Advert 4",
            522.33,
            "Just awesome 4",
            "https://via.placeholder.com/1200x900"
        ),
        Service(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130007"),
            "Awesome Advert 5",
            622.33,
            "Just awesome 5",
            "https://via.placeholder.com/1200x900"
        ),
        Service(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130008"),
            "Awesome Advert 6",
            722.33,
            "Just awesome 6",
            "https://via.placeholder.com/1200x900"
        ),
    )
}