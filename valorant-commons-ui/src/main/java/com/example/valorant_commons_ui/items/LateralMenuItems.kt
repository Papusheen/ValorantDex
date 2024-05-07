package com.example.valorant_commons_ui.items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.valorant_commons.constants.NavigationRoutes

sealed class LateralMenuItems (
    val icon: ImageVector,
    val name: String,
    val route: String,
    val position: Int,
){
    object AgentsMenuItem: LateralMenuItems(
        Icons.Rounded.Face,
        "Agents",
        NavigationRoutes.navigationContentScreen,
        0
    )

    object AgentsFavoritesMenuItem: LateralMenuItems(
        Icons.Rounded.Favorite,
        "Favorites",
        NavigationRoutes.navigationContentFavScreen,
        1
    )

    object MapMenuItem: LateralMenuItems(
        Icons.Rounded.LocationOn,
        "Maps",
        NavigationRoutes.comingSoonScreen,
        2
    )
    object OptionsMenuItem: LateralMenuItems(
        Icons.Rounded.Info,
        "Options",
        NavigationRoutes.comingSoonScreen,
        3
    )
}