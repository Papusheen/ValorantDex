package com.example.valorant_commons_ui.widgets

import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.example.valorant_commons_ui.items.LateralMenuItems
import com.example.valorant_commons_ui.textview.TitleText
import kotlinx.coroutines.launch

@Composable
fun ValorantLateralMenuDrawer(
    navController: NavHostController,
    drawerState: DrawerState,
    content: @Composable () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val menuItems = listOf(
        LateralMenuItems.AgentsMenuItem,
        LateralMenuItems.AgentsFavoritesMenuItem,
        LateralMenuItems.MapMenuItem,
        LateralMenuItems.OptionsMenuItem,
    )
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                menuItems.forEach { NavigationDrawerItem(
                    icon = { Icon(it.icon, contentDescription = null) },
                    label = { TitleText(text = it.name) },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                        navController.navigate(it.route)})
                }
            }
        }) {
        content()
    }
}