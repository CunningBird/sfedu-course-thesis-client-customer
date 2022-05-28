package com.cunningbird.thesis.client.customer.main.data.repository

import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import com.cunningbird.thesis.client.customer.main.data.client.BackendClient
import com.cunningbird.thesis.client.customer.main.data.client.IdentityClient
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.Appointment
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.AppointmentList
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.CreateAppointmentRequest
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.Chat
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.ChatList
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.Message
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.SendMessageRequest
import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import com.cunningbird.thesis.client.customer.main.domain.entities.service.ServiceList
import com.cunningbird.thesis.client.customer.main.domain.repository.BackendRepository
import com.cunningbird.thesis.client.customer.main.utils.moshi.DateJsonAdapter
import com.cunningbird.thesis.client.customer.main.utils.moshi.UuidJsonAdapter
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

class BackendRepositoryImpl(accessToken: String, private val userId: String) : BackendRepository {

    private val backendClient: BackendClient
    private val identityClient: IdentityClient

    private val backendUrl = "http://185.46.11.94:8078/customer/"
    private val identityUrl = "http://185.46.11.94:8080/"

    init {
        val clientSettings = OkHttpClient.Builder()
            .addInterceptor { chain -> addInterceptor(chain, accessToken, userId) }
            .build()
        val moshi = Moshi.Builder()
            .add(UuidJsonAdapter())
            .add(DateJsonAdapter())
            .build()


        val builder1 = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(backendUrl)
            .client(clientSettings)
            .build()
        val builder2 = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(identityUrl)
            .client(clientSettings)
            .build()

        backendClient = builder1.create(BackendClient::class.java)
        identityClient = builder2.create(IdentityClient::class.java)
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
        return backendClient.getServices()
    }

    override fun getServiceById(id: UUID): Call<Service> {
        return backendClient.getServiceById(id)
    }

    override fun getAppointments(): Call<AppointmentList> {
        return backendClient.getAppointments()
    }

    override fun getAppointment(id: UUID): Call<Appointment> {
        return backendClient.getAppointmentById(id)
    }

    override fun createAppointment(serviceId: UUID, request: CreateAppointmentRequest): Call<Appointment> {
        return backendClient.createAppointment(serviceId, request)
    }

    override fun getChats(): Call<ChatList> {
        return backendClient.getChats()
    }

    override fun getChat(id: UUID): Call<Chat> {
        return backendClient.getChatById(id)
    }

    override fun sendMessage(chatId: UUID, request: SendMessageRequest): Call<Message> {
        return backendClient.sendMessage(chatId, request)
    }

    override fun getUserId(): String {
        return userId
    }

    override fun logout(): Call<Void> {
        return identityClient.logout()
    }
}