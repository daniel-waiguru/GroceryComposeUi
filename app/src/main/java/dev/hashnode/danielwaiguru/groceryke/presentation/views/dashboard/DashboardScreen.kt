package dev.hashnode.danielwaiguru.groceryke.presentation.views.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.hashnode.danielwaiguru.groceryke.R
import dev.hashnode.danielwaiguru.groceryke.domain.models.BottomMenuItem
import dev.hashnode.danielwaiguru.groceryke.domain.models.Product
import dev.hashnode.danielwaiguru.groceryke.domain.models.Shop
import dev.hashnode.danielwaiguru.groceryke.presentation.navigation.BottomMenu
import dev.hashnode.danielwaiguru.groceryke.ui.theme.backgroundColor

@Composable
fun DashboardScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            val products = listOf(
                Product(
                    image = R.drawable.oranges,
                    name = "Orange Fruit",
                    category = "Fruit",
                    price = 2.35
                ),
                Product(
                    image = R.drawable.salad,
                    name = "Salad",
                    category = "Vegetable",
                    price = 2.35
                ),
                Product(
                    image = R.drawable.kale,
                    name = "Kales",
                    category = "Vegetables",
                    price = 2.35
                )
            )
            GreetingSection()
            Spacer(modifier = Modifier.height(20.dp))
            SearchSection()
            Spacer(modifier = Modifier.height(20.dp))
            ChipSection(chips = listOf("All", "Fruit", "Vegetable", "Moot", "Dicry"))
            Spacer(modifier = Modifier.height(20.dp))
            ProductSection(products = products)
            Spacer(modifier = Modifier.height(20.dp))
            RecentShop(shops = listOf(
                Shop(
                    name = "Celery Vegetables",
                    category = "Vegetables",
                    photo = R.drawable.vegetables,
                    price = 14.99
                ),
                Shop(
                    name = "Prince Vegetables",
                    category = "Fruit",
                    photo = R.drawable.salad,
                    price = 5.65
                ),
                Shop(
                    name = "Dope Vegetables",
                    category = "Vegetables",
                    photo = R.drawable.kale,
                    price = 2.99
                )

            ))
        }
        BottomMenu(
            items = listOf(
                BottomMenuItem(stringResource(R.string.home), R.drawable.ic_home),
                BottomMenuItem(stringResource(R.string.analytics), R.drawable.ic_analytics),
                BottomMenuItem(stringResource(R.string.sell), R.drawable.ic_document_scanner),
                BottomMenuItem(stringResource(R.string.notifications), R.drawable.ic_inbox),
                BottomMenuItem(stringResource(R.string.user_account), R.drawable.ic_person),
            ),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
@Composable
fun ProductSection(products: List<Product>) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            items(products.size) {
                RowItem(product = products[it])
            }
        }
    }
}

@Preview
@Composable
fun DashboardPreview() {
    DashboardScreen()
}