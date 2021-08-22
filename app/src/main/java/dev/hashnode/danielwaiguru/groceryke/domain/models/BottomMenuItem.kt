package dev.hashnode.danielwaiguru.groceryke.domain.models

import androidx.annotation.DrawableRes

data class BottomMenuItem(
    val title: String,
    @DrawableRes val iconId: Int
)
