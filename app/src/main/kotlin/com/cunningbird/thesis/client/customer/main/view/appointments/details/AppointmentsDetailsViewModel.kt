package com.cunningbird.thesis.client.customer.main.view.appointments.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.Appointment
import com.cunningbird.thesis.client.customer.main.domain.repository.BackendRepository
import retrofit2.Call
import java.util.UUID

class AppointmentsDetailsViewModel(application: Application, private val repository: BackendRepository) : AndroidViewModel(application) {

    fun getAppointmentById(id: UUID): Call<Appointment> {
        return repository.getAppointment(id)
    }
}