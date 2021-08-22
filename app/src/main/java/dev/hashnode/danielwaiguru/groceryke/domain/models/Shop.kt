package dev.hashnode.danielwaiguru.groceryke.domain.models

import androidx.annotation.DrawableRes

data class Shop(
    val name: String,
    val category: String,
    @DrawableRes val photo: Int,
    val price: Double
)

