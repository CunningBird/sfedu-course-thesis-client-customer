package com.cunningbird.thesis.client.customer.main.view.chats.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.ChatList
import com.cunningbird.thesis.client.customer.main.domain.repository.BackendRepository
import retrofit2.Call

class ChatsListViewModel(application: Application, private val repository: BackendRepository) : AndroidViewModel(application) {

    fun getChats(): Call<ChatList> {
        return repository.getChats()
    }
}