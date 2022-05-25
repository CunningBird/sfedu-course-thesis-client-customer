package com.cunningbird.thesis.client.customer.main.view.appointments.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.cunningbird.thesis.client.customer.R
import com.cunningbird.thesis.client.customer.databinding.FragmentAppointmentsDetailsBinding
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.Appointment
import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import com.cunningbird.thesis.client.customer.main.domain.repository.BackendRepository
import com.cunningbird.thesis.client.customer.main.view.FragmentViewModelFactory
import com.cunningbird.thesis.client.customer.main.view.MainActivity
import com.cunningbird.thesis.client.customer.main.view.services.details.ServicesDetailsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class AppointmentsDetailsFragment : Fragment() {

    private lateinit var binding: FragmentAppointmentsDetailsBinding

    private val viewModel: AppointmentsDetailsViewModel by viewModels {
        FragmentViewModelFactory(
            mainActivity.application,
            mainActivity.viewModel.backendRepository,
            BackendRepository::class.java
        )
    }

    private lateinit var mainActivity: MainActivity

    private lateinit var appointment: Appointment

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivity = (activity as MainActivity)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAppointmentsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity.changeToolbar(getString(R.string.service_details), true)

        val id = UUID.fromString(arguments!!.get("appointmentId") as String)

        viewModel.getAppointmentById(id).enqueue(object : Callback<Appointment> {
            override fun onFailure(call: Call<Appointment>, t: Throwable) {
                Log.d("MainActivity", "Request Failed: $call")
            }

            override fun onResponse(call: Call<Appointment>, response: Response<Appointment>) {
                val appointment = response.body()

                if (!response.isSuccessful || appointment == null) {
                    Log.d("MainActivity", "Request Failed: $call")
                } else {
                    Log.d("MainActivity", "Request Success")

                    binding.tvStatus.text = appointment.advertName
                    binding.tvGeo.text = appointment.date.toString() // TODO format this
                }
            }
        })
    }
}