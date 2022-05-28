package com.cunningbird.thesis.client.customer.main.domain.repository

import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.Appointment
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.AppointmentList
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.CreateAppointmentRequest
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.Chat
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.ChatList
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.Message
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.SendMessageRequest
import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service
import com.cunningbird.thesis.client.customer.main.domain.entities.service.ServiceList
import retrofit2.Call
import java.util.*

interface BackendRepository {

    fun getServices(): Call<ServiceList>

    fun getServiceById(id: UUID): Call<Service>

    fun getAppointments(): Call<AppointmentList>

    fun getAppointment(id: UUID): Call<Appointment>

    fun createAppointment(serviceId: UUID, request: CreateAppointmentRequest): Call<Appointment>

    fun getChats(): Call<ChatList>

    fun getChat(id: UUID): Call<Chat>

    fun sendMessage(chatId: UUID, request: SendMessageRequest): Call<Message>

    fun getUserId(): String

    fun logout(): Call<Void>
}