package com.cunningbird.thesis.client.customer.main.view.chats.dialog

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.Chat
import com.cunningbird.thesis.client.customer.main.domain.repository.BackendRepository
import retrofit2.Call
import java.util.UUID

class ChatsDialogViewModel(application: Application, private val repository: BackendRepository) : AndroidViewModel(application) {

    fun getUserId(): String {
        return repository.getUserId()
    }

    fun getChatById(id: UUID): Call<Chat> {
        return repository.getChat(id)
    }
}