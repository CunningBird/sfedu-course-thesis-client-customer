package com.cunningbird.thesis.client.customer.main.domain.repository

import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import retrofit2.Call

interface ServiceRepository {
    fun getServices(): Call<List<Service>>

    fun getServiceById(id: String): Call<Service>
}