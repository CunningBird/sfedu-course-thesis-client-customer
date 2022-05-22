package com.cunningbird.thesis.client.customer.main.data.client

import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceClient {

    @GET("services")
    fun getServices(): Call<List<Service>>

    @GET("services/{id}")
    fun getServiceById(
        @Path("id") id: String,
    ): Call<Service>
}