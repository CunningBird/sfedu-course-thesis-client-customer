package com.cunningbird.thesis.client.customer.main.data.client

import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.Appointment
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.AppointmentList
import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import com.cunningbird.thesis.client.customer.main.domain.entities.service.ServiceList
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.CreateAppointmentRequest
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.Chat
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.ChatList
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.SendMessageRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.*

interface BackendClient {

    @GET("adverts")
    fun getServices(): Call<ServiceList>

    @GET("adverts/{id}")
    fun getServiceById(
        @Path("id") id: UUID,
    ): Call<Service>

    @GET("appointments")
    fun getAppointments(): Call<AppointmentList>

    @GET("appointments/{id}")
    fun getAppointmentById(
        @Path("id") id: UUID,
    ): Call<Appointment>

    @POST("appointments/{serviceId}")
    fun createAppointment(
        @Path("serviceId") serviceId: UUID,
        @Body request: CreateAppointmentRequest
    ): Call<Void>

    @GET("chats")
    fun getChats(): Call<ChatList>

    @GET("chats/{id}")
    fun getChatById(
        @Path("id") id: UUID,
    ): Call<Chat>

    @POST("chats/{chatId}")
    fun sendMessage(
        @Path("chatId") serviceId: UUID,
        @Body request: SendMessageRequest
    ): Call<Void>
}