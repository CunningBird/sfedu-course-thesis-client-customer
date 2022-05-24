package com.cunningbird.thesis.client.customer.main.domain.entities.appointment

import com.squareup.moshi.Json
import java.util.*

data class Appointment(
    @field:Json(name = "id") var id: UUID? = null,
    @field:Json(name = "advertName") var advertName: String? = null,
    @field:Json(name = "date") var date: Date? = null,
)