package com.training.testapp.repository

import com.training.testapp.data.model.User
import com.training.testapp.data.wrapper.NetworkResult
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {
    fun getApiData(): Flow<NetworkResult<List<User>>>
}