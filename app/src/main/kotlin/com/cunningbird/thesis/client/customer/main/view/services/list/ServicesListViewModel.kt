package com.cunningbird.thesis.client.customer.main.view.services.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cunningbird.thesis.client.customer.main.domain.entities.service.ServiceList
import com.cunningbird.thesis.client.customer.main.domain.repository.BackendRepository
import retrofit2.Call

class ServicesListViewModel(application: Application, private val repository: BackendRepository) :
    AndroidViewModel(application) {

    fun getServices(): Call<ServiceList> {
        return repository.getServices()
    }
}