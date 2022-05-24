package com.cunningbird.thesis.client.customer.main.domain.repository

import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import com.cunningbird.thesis.client.customer.main.domain.entities.service.ServiceList
import retrofit2.Call
import java.util.UUID

interface ServiceRepository {
    fun getServices(): Call<ServiceList>

    fun getServiceById(id: UUID): Call<Service>
}