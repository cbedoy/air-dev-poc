package com.mx.airdevexample.landing

data class LandingUiState(
    val greeting: String = "",
    val subtitle: String = "",
    val cards: List<LandingCardItem> = emptyList(),
    val bottomItems: List<BottomNavItem> = emptyList(),
    val selectedBottomItemId: String = "",
    val highlightedCardId: String? = null
)
