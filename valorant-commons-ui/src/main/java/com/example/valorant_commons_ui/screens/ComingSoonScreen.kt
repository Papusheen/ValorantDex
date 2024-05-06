package com.example.valorant_commons_ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.valorant_commons_ui.textview.CardTitleText
import com.example.valorant_commons_ui.theme.AppTheme
import com.example.valorant_commons_ui.theme.ValorantViewPreviews

@Composable
fun ComingSoon() {
    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                contentAlignment = Alignment.Center
            ) {
                CardTitleText(text = "Coming Soon")
            }
        }
    )
}

@ValorantViewPreviews
@Composable
private fun PreviewLoadingScreen() {
    AppTheme {
        LoadingScreen()
    }
}