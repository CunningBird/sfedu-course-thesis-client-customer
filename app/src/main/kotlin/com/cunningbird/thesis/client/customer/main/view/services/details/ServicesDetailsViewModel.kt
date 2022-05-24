package com.cunningbird.thesis.client.customer.main.view.services.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import com.cunningbird.thesis.client.customer.main.domain.repository.ServiceRepository
import retrofit2.Call
import java.util.UUID

class ServicesDetailsViewModel(application: Application, private val repository: ServiceRepository) : AndroidViewModel(application)  {
    fun getServiceById(id: UUID): Call<Service> {
        return repository.getServiceById(id)
    }
}