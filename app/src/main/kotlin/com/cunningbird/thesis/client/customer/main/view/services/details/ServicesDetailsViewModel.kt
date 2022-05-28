package com.cunningbird.thesis.client.customer.main.view.services.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.Appointment
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.CreateAppointmentRequest
import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import com.cunningbird.thesis.client.customer.main.domain.repository.BackendRepository
import retrofit2.Call
import java.util.UUID

class ServicesDetailsViewModel(application: Application, private val repository: BackendRepository) : AndroidViewModel(application)  {

    fun getServiceById(id: UUID): Call<Service> {
        return repository.getServiceById(id)
    }

    fun appointService(serviceId: UUID, request: CreateAppointmentRequest): Call<Appointment> {
        return repository.createAppointment(serviceId, request)
    }
}