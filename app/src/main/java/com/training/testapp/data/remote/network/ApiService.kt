package com.training.testapp.data.remote.network

import com.training.testapp.data.model.User
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("user")
    fun getData(): Response<List<User>>
}