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
import com.cunningbird.thesis.client.customer.main.domain.entities.service.ServiceList
import com.cunningbird.thesis.client.customer.main.domain.repository.BackendRepository
import com.cunningbird.thesis.client.customer.main.view.FragmentViewModelFactory
import com.cunningbird.thesis.client.customer.main.view.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServicesListFragment : Fragment() {

    private lateinit var binding: FragmentServicesListBinding

    val viewModel: ServicesListViewModel by viewModels {
        FragmentViewModelFactory(
            mainActivity.application,
            mainActivity.viewModel.backendRepository,
            BackendRepository::class.java
        )
    }

    private lateinit var mainActivity: MainActivity

    private lateinit var adapter: ServicesListAdapter

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

        if (mainActivity.checkBinding()) {
            mainActivity.changeToolbar(getString(R.string.your_services), false)
        }

        adapter = ServicesListAdapter(this::onServiceClick)
        binding.rvServices.adapter = adapter

        viewModel.getServices().enqueue(object : Callback<ServiceList> {
            override fun onFailure(call: Call<ServiceList>, t: Throwable) {
                Log.d("MainActivity", "Request Failed: $call")
            }

            override fun onResponse(call: Call<ServiceList>, response: Response<ServiceList>) {
                val services = response.body()

                if (!response.isSuccessful || services == null) {
                    Log.d("MainActivity", "Request Failed: $call")
                } else {
                    Log.d("MainActivity", "Request Success")
                    adapter.list = services.list!!
                }
            }
        })
    }

    private fun onServiceClick(i: Int) {
        val id = adapter.list[i].id.toString()
        val arg = bundleOf("serviceId" to id)
        findNavController().navigate(R.id.action_servicesListFragment_to_servicesDetailsFragment, arg)
    }
}