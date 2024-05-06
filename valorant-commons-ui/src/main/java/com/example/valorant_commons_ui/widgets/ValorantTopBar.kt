package com.example.valorant_commons_ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.valorant_commons_ui.R
import com.example.valorant_commons_ui.theme.onPrimaryLight
import com.example.valorant_commons_ui.theme.valorantMenusColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ValorantTopBar(
    drawerState: DrawerState,
    scope: CoroutineScope) {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = R.drawable.valorant_header),
                    contentDescription = "Vector Image"
                )
            }
        },
        colors = TopAppBarColors( containerColor = valorantMenusColor,
            scrolledContainerColor = onPrimaryLight,
            navigationIconContentColor = onPrimaryLight,
            titleContentColor = onPrimaryLight,
            actionIconContentColor = onPrimaryLight),
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    drawerState.open()
                }
            }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
    )
}