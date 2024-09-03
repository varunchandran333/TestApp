package com.training.testapp.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.training.testapp.data.model.User
import com.training.testapp.data.wrapper.NetworkResult
import com.training.testapp.ui.widgets.ListUI
import com.training.testapp.viewmodel.MainViewModel
import org.koin.core.logger.KOIN_TAG

@Composable
private fun Render(
    modifier: Modifier = Modifier,
    uiState: NetworkResult<List<User>>
) {
    when (uiState) {
        is NetworkResult.Loading -> {
            Log.d(KOIN_TAG, "Loading  -->" + uiState.isLoading.toString())
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }

        is NetworkResult.Success -> {
            ListUI(modifier, users = uiState.data)

        }

        is NetworkResult.Error -> {
            Log.d(KOIN_TAG, "Error  -->" + uiState.message.toString())
        }

        is NetworkResult.Exception -> {
            Log.d(KOIN_TAG, "Exception  -->" + uiState.e.message.toString())

        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel
) {
    val uiState = mainViewModel.userData.collectAsState().value
    Render(modifier, uiState = uiState)
}