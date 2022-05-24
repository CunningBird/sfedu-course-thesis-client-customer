package com.cunningbird.thesis.client.customer.main.data.client

import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import com.cunningbird.thesis.client.customer.main.domain.entities.service.ServiceList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.UUID

interface ServiceClient {

    @GET("adverts")
    fun getServices(): Call<ServiceList>

    @GET("adverts/{id}")
    fun getServiceById(
        @Path("id") id: UUID,
    ): Call<Service>
}