package com.cunningbird.thesis.client.customer.main.domain.entities.appointment

import com.squareup.moshi.Json
import java.util.*

data class Appointment(
    @field:Json(name = "id") var id: UUID? = null,
    @field:Json(name = "serviceId") var serviceId: UUID? = null,
    @field:Json(name = "customerName") var customerName: String? = null,
    @field:Json(name = "customerId") var customerId: UUID? = null,
    @field:Json(name = "executorId") var executorId: UUID? = null,
    @field:Json(name = "address") var address: String? = null,
    @field:Json(name = "confirmed") var confirmed: Boolean? = null,
    @field:Json(name = "date") var date: Date? = null,
    @field:Json(name = "status") var status: AppointmentStatus? = null,
    @field:Json(name = "note") var note: String? = null,
)