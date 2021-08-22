package dev.hashnode.danielwaiguru.groceryke.domain.models

import androidx.annotation.DrawableRes

data class Product(
    @DrawableRes val image: Int,
    val name: String,
    val category: String,
    val price: Double
)
