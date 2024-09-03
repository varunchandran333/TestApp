package com.training.testapp.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.training.testapp.data.model.User

@Composable
fun UserUI(modifier: Modifier = Modifier, user: User) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Row {
                user.id?.let {
                    Text(
                        text = it.toString(),
                        modifier = modifier.padding(12.dp)
                    )
                }
                user.title?.let {
                    Text(
                        text = it,
                        modifier = modifier.padding(12.dp)
                    )
                }
            }
        }

    }
}