package com.cunningbird.thesis.client.customer.main.view.appointments.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.AppointmentList
import com.cunningbird.thesis.client.customer.main.domain.repository.BackendRepository
import retrofit2.Call

class AppointmentsListViewModel(application: Application, private val repository: BackendRepository) :
    AndroidViewModel(application) {

    fun getAppointments(): Call<AppointmentList> {
        return repository.getAppointments()
    }
}