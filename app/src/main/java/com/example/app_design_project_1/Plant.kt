package com.example.app_design_project_1

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.Modifier

data class Plant(
    @DrawableRes val imageResId: Int,
    @StringRes val stringResId: Int,
    val scientificNameId: String,
    val category: String,
    val description: String,
    val modifier: Modifier,
)
