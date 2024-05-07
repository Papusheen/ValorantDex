package com.example.valorant_commons_ui.widgets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.valorant_commons.constants.NavigationRoutes.Companion.comingSoonScreen
import com.example.valorant_commons.constants.NavigationRoutes.Companion.navigationContentFavScreen
import com.example.valorant_commons.constants.NavigationRoutes.Companion.navigationContentScreen


@Composable
fun ValorantBottomNavigationBar(navController: NavController,) {
    var bottomBarSelectedItem by remember { mutableIntStateOf(0) }

    BottomAppBar {
        NavigationBar {
            NavigationBarItem(
                selected = bottomBarSelectedItem == 0,
                onClick = {
                    bottomBarSelectedItem = 0
                    navController.navigate(navigationContentScreen)
                },
                icon = {
                    Icon(Icons.Rounded.Face, contentDescription = null)
                }
            )
            NavigationBarItem(
                selected = bottomBarSelectedItem == 1,
                onClick = {
                    bottomBarSelectedItem = 1
                    navController.navigate(navigationContentFavScreen)
                },
                icon = {
                    Icon(Icons.Rounded.Favorite, contentDescription = null)
                }
            )
            NavigationBarItem(
                selected = bottomBarSelectedItem == 2,
                onClick = {
                    bottomBarSelectedItem = 2
                    navController.navigate(comingSoonScreen)
                },
                icon = {
                    Icon(Icons.Rounded.LocationOn, contentDescription = null)
                }
            )
            NavigationBarItem(
                selected = bottomBarSelectedItem == 3,
                onClick = {
                    bottomBarSelectedItem = 3
                    navController.navigate(comingSoonScreen)
                },
                icon = {
                    Icon(Icons.Rounded.Info, contentDescription = null)
                }
            )
        }
    }
}