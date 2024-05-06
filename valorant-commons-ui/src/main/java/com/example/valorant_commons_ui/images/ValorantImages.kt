package com.example.valorant_commons_ui.images

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.valorant_commons_ui.R
import com.example.valorant_commons_ui.theme.AppTheme
import com.example.valorant_commons_ui.theme.ValorantViewPreviews
import com.example.valorant_commons_ui.theme.secondaryContainerLight


@Composable
    fun AgentCardImage(urlAgent: String?, urlBackgroundAgent: String?, modifier: Modifier = Modifier) {
            Box(modifier = modifier.width(200.dp).height(180.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .border(5.dp, secondaryContainerLight, shape = RoundedCornerShape(15.dp)),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(urlBackgroundAgent)
                        .crossfade(true)
                        .build(),
                    placeholder = null,
                    contentDescription = null,
                    contentScale = ContentScale.None,
                    modifier = Modifier.fillMaxSize(),
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(urlAgent)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.valorant_placeholder_logo),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .clip(RoundedCornerShape(75.dp))
                        .fillMaxSize()
                )

            }
    }

    @ValorantViewPreviews
    @Composable
    fun ComposablePreview() {
        AppTheme{
            Surface {
                Column (Modifier.fillMaxSize()){
                    AgentCardImage("","")
                }
            }
        }
    }