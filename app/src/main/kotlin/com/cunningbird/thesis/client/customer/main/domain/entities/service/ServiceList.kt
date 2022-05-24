package com.cunningbird.thesis.client.customer.main.domain.entities.service

import com.squareup.moshi.Json
import java.util.*

data class ServiceList(
    @field:Json(name = "list") var list: List<Service>? = null,
)