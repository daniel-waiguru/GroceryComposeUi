package dev.hashnode.danielwaiguru.groceryke.presentation.views.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.hashnode.danielwaiguru.groceryke.R
import dev.hashnode.danielwaiguru.groceryke.domain.models.BottomMenuItem
import dev.hashnode.danielwaiguru.groceryke.presentation.navigation.BottomMenu
import dev.hashnode.danielwaiguru.groceryke.presentation.navigation.BottomNavItem

@Composable
fun DashboardScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            GreetingSection()
            SearchSection()
            ChipSection(chips = listOf("All", "Fruit", "Vegetable", "Moot", "Dicry"))

            RecentShop(shops = listOf())
        }
        BottomMenu(
            items = listOf(
                BottomMenuItem(stringResource(R.string.home), R.drawable.ic_home),
                BottomMenuItem(stringResource(R.string.analytics), R.drawable.ic_analytics),
                BottomMenuItem(stringResource(R.string.sell), R.drawable.ic_document_scanner),
                BottomMenuItem(stringResource(R.string.notifications), R.drawable.ic_inbox),
                BottomMenuItem(stringResource(R.string.user_account), R.drawable.ic_person),
            )
        )
    }
}

@Preview
@Composable
fun DashboardPreview() {
    DashboardScreen()
}