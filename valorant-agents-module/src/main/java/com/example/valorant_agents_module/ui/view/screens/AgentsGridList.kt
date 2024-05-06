package com.example.valorant_agents_module.ui.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.valorant_agents_module.domain.models.AgentDomainModel
import com.example.valorant_agents_module.ui.view.widgets.AgentCartView
import com.example.valorant_commons_ui.theme.AppTheme
import com.example.valorant_commons_ui.theme.ValorantViewPreviews
import com.example.valorant_commons_ui.theme.backgroundDark

@Composable
fun AgentsGridList(
    list: List<AgentDomainModel>,
    modifier: Modifier = Modifier,
    navController: NavController,
) {
        LazyVerticalGrid(
            modifier = modifier
                .fillMaxSize()
                .background(backgroundDark),
            columns = GridCells.Adaptive(minSize = 200.dp)
        ) {
            items(list.size) { index ->
                AgentCartView(
                    agentDomainModel = list[index],
                    navController = navController)
            }
        }
}

@ValorantViewPreviews
@Composable
private fun ComposablePreview() {
    AppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column (modifier = Modifier.fillMaxSize()){

            }
        }
    }
}