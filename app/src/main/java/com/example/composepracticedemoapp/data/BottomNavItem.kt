package com.example.composepracticedemoapp.data

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Created by Tirth Patel.
 */
data class BottomNavItem(
    val name: String,
    val route : String,
    val checkedIcon: ImageVector,
    val uncheckedIcon: ImageVector,
    val badgeCount: Int = 0
    )
