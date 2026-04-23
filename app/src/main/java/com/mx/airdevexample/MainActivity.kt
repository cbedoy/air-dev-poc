package com.mx.airdevexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mx.airdevexample.landing.LandingRoute
import com.mx.airdevexample.landing.LandingViewModel
import com.mx.airdevexample.ui.theme.AirDevExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AirDevExampleTheme {
                LandingScreenContainer()
            }
        }
    }
}

@Composable
private fun LandingScreenContainer(
    viewModel: LandingViewModel = viewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        LandingRoute(
            modifier = Modifier.padding(innerPadding),
            uiState = uiState.value,
            onBottomItemSelected = viewModel::onBottomItemSelected,
            onPrimaryActionClick = viewModel::onPrimaryActionClick
        )
    }
}
