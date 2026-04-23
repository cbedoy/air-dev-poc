package com.mx.airdevexample.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FavoritesRoute(viewModel: FavoritesViewModel = viewModel()) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    FavoritesScreen(uiState = uiState.value)
}

@Composable
fun FavoritesScreen(uiState: FavoritesUiState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = uiState.title, style = MaterialTheme.typography.headlineMedium)
        Text(text = uiState.description, style = MaterialTheme.typography.bodyLarge)
    }
}
