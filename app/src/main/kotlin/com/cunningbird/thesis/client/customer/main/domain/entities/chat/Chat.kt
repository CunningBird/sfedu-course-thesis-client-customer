package com.cunningbird.thesis.client.customer.main.domain.entities.chat

import com.squareup.moshi.Json
import java.util.*

data class Chat(
    @field:Json(name = "id") var id: UUID? = null,
    @field:Json(name = "customerId") var customerId: UUID? = null,
    @field:Json(name = "executorId") var executorId: UUID? = null,
    @field:Json(name = "messages") var messages: MutableList<Message> = mutableListOf()
)