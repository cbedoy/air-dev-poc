package com.mx.airdevexample.landing

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class LandingCardItem(
    val id: String,
    val name: String,
    val imageUrl: String
)

data class BottomNavItem(
    val id: String,
    val label: String,
    val icon: ImageVector,
    val isFab: Boolean = false
)

val DefaultLandingCards = listOf(
    LandingCardItem(
        id = "1",
        name = "Explora destinos urbanos",
        imageUrl = "https://images.unsplash.com/photo-1514565131-fce0801e5785?auto=format&fit=crop&w=1200&q=80"
    ),
    LandingCardItem(
        id = "2",
        name = "Momentos para compartir",
        imageUrl = "https://images.unsplash.com/photo-1529156069898-49953e39b3ac?auto=format&fit=crop&w=1200&q=80"
    ),
    LandingCardItem(
        id = "3",
        name = "Ideas para tu siguiente salida",
        imageUrl = "https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1200&q=80"
    ),
    LandingCardItem(
        id = "4",
        name = "Recomendaciones personalizadas",
        imageUrl = "https://images.unsplash.com/photo-1494526585095-c41746248156?auto=format&fit=crop&w=1200&q=80"
    )
)

val DefaultBottomNavItems = listOf(
    BottomNavItem(id = "home", label = "Inicio", icon = Icons.Filled.Home),
    BottomNavItem(id = "search", label = "Buscar", icon = Icons.Filled.Search),
    BottomNavItem(id = "create", label = "Crear", icon = Icons.Filled.Add, isFab = true),
    BottomNavItem(id = "favorites", label = "Favoritos", icon = Icons.Filled.Favorite),
    BottomNavItem(id = "profile", label = "Perfil", icon = Icons.Filled.AccountCircle)
)

fun defaultLandingUiState() = LandingUiState(
    greeting = "Descubre lo que sigue",
    subtitle = "Colecciona ideas, inspira a tu equipo y configura cada tarjeta desde el estado de la pantalla.",
    cards = DefaultLandingCards,
    bottomItems = DefaultBottomNavItems,
    selectedBottomItemId = DefaultBottomNavItems.first().id,
    highlightedCardId = DefaultLandingCards.first().id
)
