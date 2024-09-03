package com.training.testapp.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.training.testapp.data.model.User
import com.training.testapp.data.remote.network.ApiService
import com.training.testapp.data.wrapper.NetworkResult
import com.training.testapp.data.wrapper.handleApi
import com.training.testapp.utils.readJsonFromAssets
import retrofit2.Response

class DataSource(
    private val context: Context, private val apiService: ApiService
) {
    private fun getData(): List<User> {
        val gson = Gson()
        val type = object : TypeToken<List<User>>() {}.type
        val jsonString = readJsonFromAssets(context, "user.json")
        val users: List<User> = gson.fromJson(jsonString, type)
        return users
    }

    suspend fun getApiData(): NetworkResult<List<User>> = handleApi {
        //apiService.getData()
        Response.success(getData())
    }


}