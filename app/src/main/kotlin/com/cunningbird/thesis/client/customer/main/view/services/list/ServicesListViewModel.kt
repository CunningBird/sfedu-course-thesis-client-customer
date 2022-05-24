package com.cunningbird.thesis.client.customer.main.view.services.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import com.cunningbird.thesis.client.customer.main.domain.entities.service.ServiceList
import com.cunningbird.thesis.client.customer.main.domain.repository.ServiceRepository
import retrofit2.Call

class ServicesListViewModel(application: Application, private val repository: ServiceRepository) :
    AndroidViewModel(application) {

    fun getServices(): Call<ServiceList> {
        return repository.getServices()
    }

    fun getServiceById(id: String): Call<Service> {
        return repository.getServiceById(id)
    }
}