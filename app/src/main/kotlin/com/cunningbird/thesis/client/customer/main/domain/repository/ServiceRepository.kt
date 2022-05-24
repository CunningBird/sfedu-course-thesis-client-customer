package com.cunningbird.thesis.client.customer.main.domain.repository

import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import com.cunningbird.thesis.client.customer.main.domain.entities.service.ServiceList
import retrofit2.Call

interface ServiceRepository {
    fun getServices(): Call<ServiceList>

    fun getServiceById(id: String): Call<Service>
}