package com.training.testapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.testapp.data.model.User
import com.training.testapp.data.wrapper.NetworkResult
import com.training.testapp.repository.RepositoryImpl
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(repository: RepositoryImpl) : ViewModel() {

    val userData: StateFlow<NetworkResult<List<User>>> =
        repository.getApiData()
            .stateIn(
                scope = viewModelScope,
                initialValue = NetworkResult.Loading(true),
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000)
            )


}