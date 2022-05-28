package com.cunningbird.thesis.client.customer.main.view.account

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.ChatList
import com.cunningbird.thesis.client.customer.main.domain.repository.BackendRepository
import retrofit2.Call

class AccountViewModel(application: Application, private val repository: BackendRepository) : AndroidViewModel(application) {

    fun getUserName(): String {
        //return repository.getUserId()
        return "Executor" // TODO get from repository
    }

    fun logout(): Call<Void> {
        return repository.logout()
    }
}