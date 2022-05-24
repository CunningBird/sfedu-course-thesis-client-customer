package com.cunningbird.thesis.client.customer.main.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cunningbird.thesis.client.customer.main.data.repository.ServiceRepositoryImpl
import com.cunningbird.thesis.client.customer.main.domain.repository.ServiceRepository

class MainViewModel(application: Application, accessToken: String, userId: String) : AndroidViewModel(application) {

    val serviceRepository: ServiceRepository = ServiceRepositoryImpl(accessToken, userId)
}