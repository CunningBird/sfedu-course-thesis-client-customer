package com.cunningbird.thesis.client.customer.main.data.client

import retrofit2.Call
import retrofit2.http.GET

interface IdentityClient {

    @GET("logout")
    fun logout(): Call<Void>
}