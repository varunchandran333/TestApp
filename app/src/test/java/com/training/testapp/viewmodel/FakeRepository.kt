package com.training.testapp.viewmodel

import com.training.testapp.data.model.User
import com.training.testapp.data.wrapper.NetworkResult
import com.training.testapp.data.wrapper.handleApi
import com.training.testapp.repository.RepositoryInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class FakeRepository : RepositoryInterface {
    override fun getApiData(): Flow<NetworkResult<List<User>>> = flow {
        handleApi {
            val list = mutableListOf<User>()
            list.add(User(1, "Varun", true))
            list.add(User(2, "Chandran", true))
            list.add(User(3, "Veena", false))
            list.add(User(4, "Arun", true))
            Response.success(list)
        }
    }
}