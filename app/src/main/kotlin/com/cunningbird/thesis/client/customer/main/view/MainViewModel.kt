package com.cunningbird.thesis.client.customer.main.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cunningbird.thesis.client.customer.main.data.repository.BackendRepositoryImpl
import com.cunningbird.thesis.client.customer.main.domain.repository.BackendRepository

class MainViewModel(application: Application, accessToken: String, userId: String) : AndroidViewModel(application) {

    val backendRepository: BackendRepository = BackendRepositoryImpl(accessToken, userId)
}