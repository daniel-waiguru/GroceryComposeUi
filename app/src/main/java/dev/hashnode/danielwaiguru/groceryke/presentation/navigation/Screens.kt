package dev.hashnode.danielwaiguru.groceryke.presentation.navigation

sealed class Screen(val route: String) {
    object WelcomeScreen: Screen("welcome_screen")
    object DetailsScreen: Screen("detail_screen")
    object DashboardScreen: Screen("dashboard_screen")
}