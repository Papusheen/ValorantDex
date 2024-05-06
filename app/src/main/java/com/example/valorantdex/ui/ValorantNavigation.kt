package com.example.valorantdex.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.valorant_agents_module.ui.view.screens.AgentDetails
import com.example.valorant_commons.constants.NavigationRoutes.Companion.agentDetailsScreen
import com.example.valorant_commons.constants.NavigationRoutes.Companion.comingSoonScreen
import com.example.valorant_commons.constants.NavigationRoutes.Companion.navigationContentScreen
import com.example.valorant_commons_ui.screens.ComingSoon


@Composable
fun ValorantNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = navigationContentScreen) {
        composable(navigationContentScreen) { ValorantTapContent(navController = navController) }
        composable(agentDetailsScreen) { backStackEntry ->
                val userId = backStackEntry.arguments?.getString("agentId")
            if (userId != null) {
                AgentDetails(agentId = userId)
            }
        }
        composable(comingSoonScreen) { ComingSoon() }
    }
}