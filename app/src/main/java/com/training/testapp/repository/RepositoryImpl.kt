package com.training.testapp.repository

import com.training.testapp.data.model.User
import com.training.testapp.data.wrapper.NetworkResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(
    private val dataSource: DataSource
) {
    fun getApiData(): Flow<NetworkResult<List<User>>> = flow {
        delay(2000)
        emit(dataSource.getApiData())
    }
}