package com.training.testapp.repository

import android.content.Context
import com.training.testapp.data.model.User
import com.training.testapp.data.remote.network.ApiService
import com.training.testapp.data.wrapper.NetworkResult
import com.training.testapp.data.wrapper.handleApi
import com.training.testapp.utils.getUsersData
import retrofit2.Response

class DataSource(
    private val context: Context, private val apiService: ApiService
) {
    private fun getData(): List<User> {
        return getUsersData(context)
    }

    suspend fun getApiData(): NetworkResult<List<User>> = handleApi {
        //apiService.getData()
        Response.success(getData())
    }


}