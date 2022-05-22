package com.cunningbird.thesis.client.customer.main.view.services.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cunningbird.thesis.client.customer.main.domain.repository.ServiceRepository

class ServicesDetailsViewModel(application: Application, private val repository: ServiceRepository) : AndroidViewModel(application)  {
}