package com.cunningbird.thesis.client.customer.main.data.repository

import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import com.cunningbird.thesis.client.customer.main.data.client.ServiceClient
import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import com.cunningbird.thesis.client.customer.main.domain.entities.service.ServiceList
import com.cunningbird.thesis.client.customer.main.domain.repository.ServiceRepository
import com.cunningbird.thesis.client.customer.main.utils.moshi.UuidJsonAdapter
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

class ServiceRepositoryImpl(accessToken: String, userId: String) : ServiceRepository {

    private val client: ServiceClient

    private val baseUrl = "http://185.46.11.94:8078/customer/"

    init {
        val clientSettings = OkHttpClient.Builder()
            .addInterceptor { chain -> addInterceptor(chain, accessToken, userId) }
            .build()

        val moshi = Moshi.Builder()
            .add(UuidJsonAdapter())
            .build()

        val builder = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
            .client(clientSettings)
            .build()

        client = builder.create(ServiceClient::class.java)
    }

    private fun addInterceptor(chain: Interceptor.Chain, accessToken: String, userId: String): Response {
        val original = chain.request()
        val edited = original.newBuilder()
            .addHeader("Authorization", "Bearer $accessToken")
            .addHeader("customer_id", userId)
            .build()
        return chain.proceed(edited)
    }

    override fun getServices(): Call<ServiceList> {
        return client.getServices()
    }

    override fun getServiceById(id: String): Call<Service> {
        return client.getServiceById(id)
    }
}