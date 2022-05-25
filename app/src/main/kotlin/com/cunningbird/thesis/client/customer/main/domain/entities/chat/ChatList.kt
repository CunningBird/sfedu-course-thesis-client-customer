package com.cunningbird.thesis.client.customer.main.domain.entities.chat

import com.squareup.moshi.Json

data class ChatList(
    @field:Json(name = "list") var list: List<Chat>? = null,
)