package com.cunningbird.thesis.client.customer.main.view.appointments.list

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
import com.cunningbird.thesis.client.customer.databinding.FragmentAppointmentsListBinding
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.AppointmentList
import com.cunningbird.thesis.client.customer.main.domain.repository.BackendRepository
import com.cunningbird.thesis.client.customer.main.view.FragmentViewModelFactory
import com.cunningbird.thesis.client.customer.main.view.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppointmentsListFragment : Fragment() {

    private lateinit var binding: FragmentAppointmentsListBinding

    private val viewModel: AppointmentsListViewModel by viewModels {
        FragmentViewModelFactory(
            mainActivity.application,
            mainActivity.viewModel.backendRepository,
            BackendRepository::class.java
        )
    }

    private lateinit var mainActivity: MainActivity

    private lateinit var adapter: AppointmentsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivity = (activity as MainActivity)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAppointmentsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity.changeToolbar(getString(R.string.your_appointments), false)

        adapter = AppointmentsListAdapter(this::onAppointmentClick)
        binding.rvSchedule.adapter = adapter

        viewModel.getAppointments().enqueue(object : Callback<AppointmentList> {
            override fun onFailure(call: Call<AppointmentList>, t: Throwable) {
                Log.d("MainActivity", "Request Failed: $call")
            }

            override fun onResponse(call: Call<AppointmentList>, response: Response<AppointmentList>) {
                val appointments = response.body()

                if (!response.isSuccessful || appointments == null) {
                    Log.d("MainActivity", "Request Failed: $call")
                } else {
                    Log.d("MainActivity", "Request Success")
                    adapter.list = appointments.list!!
                }
            }
        })
    }

    private fun onAppointmentClick(i: Int) {
        val id = adapter.list[i].id.toString()
        val arg = bundleOf("appointmentId" to id)
        findNavController().navigate(R.id.action_appointmentsListFragment_to_appointmentsDetailsFragment, arg)
    }
}