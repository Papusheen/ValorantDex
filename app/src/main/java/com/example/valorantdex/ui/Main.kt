package com.example.valorantdex.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.valorant_agents_module.ui.view.screens.AgentsGridList
import com.example.valorant_agents_module.ui.viewmodels.AgentViewModel
import com.example.valorant_commons.network.data.ValorantNetworkResult
import com.example.valorant_commons_ui.screens.LoadingScreen
import com.example.valorant_commons_ui.theme.AppTheme
import com.example.valorant_commons_ui.widgets.ValorantBottomNavigationBar
import com.example.valorant_commons_ui.widgets.ValorantLateralMenuDrawer
import com.example.valorant_commons_ui.widgets.ValorantTopBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            AppTheme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                ValorantLateralMenuDrawer(
                    navController = navController,
                    drawerState = drawerState,
                ) {
                    Dashboard(navController,drawerState,scope)
                }
            }
        }
    }
}

@Composable
fun Dashboard(navController: NavHostController, drawerState: DrawerState, scope: CoroutineScope) {
    Scaffold(
        topBar = {
            ValorantTopBar(drawerState = drawerState, scope = scope)
        },
        content = {
            Box(Modifier
                .fillMaxSize()
                .padding(it)) {
                ValorantNavigation(navController = navController)
            }
        },
        bottomBar = {
            ValorantBottomNavigationBar(navController = navController)
        },
    )
}

@Composable
fun ValorantTapContent(navController: NavController, viewModel: AgentViewModel = hiltViewModel<AgentViewModel>()) {
    val agents = viewModel.agentsLiveData.observeAsState()
    val refreshCount by remember { mutableIntStateOf(0) }
    LaunchedEffect(key1 = refreshCount) {
        viewModel.getAgents()
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        if (agents.value is ValorantNetworkResult.LoadingStatus) {
            LoadingScreen()
        } else {
            agents.value?.data?.let { agents -> AgentsGridList(agents, navController = navController) }
        }
    }
}

@Preview
@Composable
fun MyScreenPreview() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Dashboard(navController, drawerState, scope)
}
