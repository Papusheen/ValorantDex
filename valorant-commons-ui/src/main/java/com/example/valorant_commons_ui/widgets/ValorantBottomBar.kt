package com.example.valorant_commons_ui.widgets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Menu
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
import com.example.valorant_commons.constants.NavigationRoutes.Companion.navigationContentScreen


@Composable
fun ValorantBottomNavigationBar(navController: NavController,) {
    var selectedItem by remember { mutableIntStateOf(0) }

    BottomAppBar {
        NavigationBar {
            NavigationBarItem(
                selected = selectedItem == 0,
                onClick = {
                    selectedItem = 0
                    navController.navigate(navigationContentScreen)
                },
                icon = {
                    Icon(Icons.Rounded.Face, contentDescription = null)
                }
            )
            NavigationBarItem(
                selected = selectedItem == 1,
                onClick = {
                    selectedItem = 1
                    navController.navigate(comingSoonScreen)
                },
                icon = {
                    Icon(Icons.Rounded.LocationOn, contentDescription = null)
                }
            )
            NavigationBarItem(
                selected = selectedItem == 2,
                onClick = {
                    selectedItem = 2
                    navController.navigate(comingSoonScreen)
                },
                icon = {
                    Icon(Icons.Rounded.Info, contentDescription = null)
                }
            )
        }
    }
}