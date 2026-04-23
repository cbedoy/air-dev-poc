package com.mx.airdevexample.landing

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LandingViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(defaultLandingUiState())
    val uiState: StateFlow<LandingUiState> = _uiState.asStateFlow()

    fun onBottomItemSelected(itemId: String) {
        _uiState.update { current ->
            current.copy(selectedBottomItemId = itemId)
        }
    }

    fun onPrimaryActionClick() {
        _uiState.update { current ->
            val nextCardId = current.cards
                .map { it.id }
                .let { ids ->
                    if (ids.isEmpty()) return@update current
                    val currentIndex = ids.indexOf(current.highlightedCardId)
                    ids[(currentIndex + 1).mod(ids.size)]
                }

            current.copy(
                selectedBottomItemId = current.bottomItems.firstOrNull { it.isFab }?.id
                    ?: current.selectedBottomItemId,
                highlightedCardId = nextCardId
            )
        }
    }
}
