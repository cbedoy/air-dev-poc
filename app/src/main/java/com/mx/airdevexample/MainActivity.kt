package com.mx.airdevexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mx.airdevexample.create.CreateRoute
import com.mx.airdevexample.favorites.FavoritesRoute
import com.mx.airdevexample.home.HomeRoute
import com.mx.airdevexample.navigation.CreateDestination
import com.mx.airdevexample.navigation.FavoritesDestination
import com.mx.airdevexample.navigation.HomeDestination
import com.mx.airdevexample.navigation.ProfileDestination
import com.mx.airdevexample.navigation.SearchDestination
import com.mx.airdevexample.profile.ProfileRoute
import com.mx.airdevexample.search.SearchRoute
import com.mx.airdevexample.ui.theme.AirDevExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AirDevExampleTheme {
                AirDevExampleApp()
            }
        }
    }
}

@Composable
private fun AirDevExampleApp() {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination
    val bottomItems = listOf(
        BottomNavItem("Inicio", Icons.Filled.Home, HomeDestination),
        BottomNavItem("Buscar", Icons.Filled.Search, SearchDestination),
        BottomNavItem("Crear", Icons.Filled.Add, CreateDestination),
        BottomNavItem("Favoritos", Icons.Filled.Favorite, FavoritesDestination),
        BottomNavItem("Perfil", Icons.Filled.AccountCircle, ProfileDestination)
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                bottomItems.forEach { item ->
                    NavigationBarItem(
                        selected = currentDestination?.hasRoute(item.route::class) == true,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(imageVector = item.icon, contentDescription = item.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeDestination,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable<HomeDestination> { HomeRoute() }
            composable<SearchDestination> { SearchRoute() }
            composable<CreateDestination> { CreateRoute() }
            composable<FavoritesDestination> { FavoritesRoute() }
            composable<ProfileDestination> { ProfileRoute() }
        }
    }
}

private data class BottomNavItem<T : Any>(
    val label: String,
    val icon: ImageVector,
    val route: T
)
