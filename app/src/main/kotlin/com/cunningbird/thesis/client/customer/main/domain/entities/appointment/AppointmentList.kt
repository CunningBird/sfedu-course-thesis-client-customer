package com.cunningbird.thesis.client.customer.main.domain.entities.appointment

import com.squareup.moshi.Json

data class AppointmentList(
    @field:Json(name = "list") var list: List<Appointment>? = null,
)