package com.example.valorant_commons_ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.valorant_commons_ui.messures.cardMediumPadding
import com.example.valorant_commons_ui.theme.AppTheme
import com.example.valorant_commons_ui.theme.ValorantViewPreviews
import com.example.valorant_commons_ui.theme.secondaryContainerLight

@Composable
fun LoadingScreen() {
    Box(
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = secondaryContainerLight)
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