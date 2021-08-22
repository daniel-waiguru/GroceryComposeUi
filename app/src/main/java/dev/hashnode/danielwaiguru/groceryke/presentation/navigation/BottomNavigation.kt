package dev.hashnode.danielwaiguru.groceryke.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.hashnode.danielwaiguru.groceryke.domain.models.BottomMenuItem
import dev.hashnode.danielwaiguru.groceryke.ui.theme.secondaryColor


@Composable
fun BottomMenu(
    items: List<BottomMenuItem>,
    modifier: Modifier = Modifier,
    activeColor: Color = secondaryColor,
    inactiveColor: Color = Color.LightGray,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, bottomMenuItem ->
            BottomNavItem(
                item = bottomMenuItem,
                isSelected = index == selectedItemIndex,
                activeColor = activeColor,
                inactiveColor = inactiveColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomNavItem(
    item: BottomMenuItem,
    isSelected: Boolean = false,
    activeColor: Color = secondaryColor,
    inactiveColor: Color = Color.LightGray,
    onItemClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                onItemClick()
            }
    ) {
        Icon(
            painter = painterResource(id = item.iconId),
            contentDescription = item.title,
            tint = if (isSelected) activeColor else inactiveColor,
            modifier = Modifier.size(20.dp)
        )
    }
}