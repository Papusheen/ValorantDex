package com.example.valorant_agents_module.ui.view.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.valorant_agents_module.domain.models.AbilityDomainModel
import com.example.valorant_agents_module.ui.viewmodels.AgentViewModel
import com.example.valorant_commons.network.data.ValorantNetworkResult
import com.example.valorant_commons_ui.messures.broderStrokeShape
import com.example.valorant_commons_ui.messures.roundedCornerShapeButton
import com.example.valorant_commons_ui.screens.LoadingScreen
import com.example.valorant_commons_ui.textview.BodyTextParagraph
import com.example.valorant_commons_ui.textview.TitleText
import com.example.valorant_commons_ui.theme.onPrimaryContainerLight
import com.example.valorant_commons_ui.theme.onPrimaryLight
import com.example.valorant_commons_ui.theme.primaryLight
import com.example.valorant_commons_ui.theme.secondaryContainerLight

@Composable
fun AgentDetails(
    agentId: String,
    modifier: Modifier = Modifier,
    viewModel: AgentViewModel = hiltViewModel<AgentViewModel>()
) {
    val agent = viewModel.agentByIdLiveData.observeAsState()
    val refreshCount by remember { mutableIntStateOf(0) }
    LaunchedEffect(key1 = refreshCount) {
        viewModel.getAgentById(agentId)
    }
    Column(modifier = modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        if (agent.value is ValorantNetworkResult.LoadingStatus) {
            LoadingScreen()
        } else {
            TitleText(text = "//Name: "+agent.value?.data?.displayName)
            AgentBodyImage(agentImageUrl = agent.value?.data?.fullPortrait,
                agentBackgroundImageUrl = agent.value?.data?.background)
            TitleText(text = "//Biography")
            Spacer(modifier = Modifier.height(20.dp))
            BodyTextParagraph(text = agent.value?.data?.description)
            Spacer(modifier = Modifier.height(20.dp))
            TitleText(text = "//Abilities")
            Spacer(modifier = Modifier.height(20.dp))
            AbilitySelectionScreen(agent.value?.data?.abilities)
        }
    }
}

@Composable
fun AgentBodyImage(
    modifier: Modifier = Modifier,
    agentImageUrl: String?,
    agentBackgroundImageUrl: String?
) {
    Box(
        modifier
            .fillMaxWidth()
            .offset(y = (-25).dp)
            .height(600.dp)) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(agentBackgroundImageUrl)
                .crossfade(true)
                .build(),
            placeholder = null,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize(),
        )
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(agentImageUrl)
                .crossfade(true)
                .build(),
            placeholder = null,
            contentDescription = null,
            contentScale = ContentScale.None,
            modifier = Modifier.fillMaxSize(),
        )  
    }
}

@Composable
fun AbilitySelectionScreen(abilities: List<AbilityDomainModel>?) {
    var selectedAbility by remember { mutableStateOf(abilities?.first()) }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            abilities?.forEach { ability ->
                Button(
                    onClick = { selectedAbility = ability },
                    modifier = Modifier.wrapContentSize(),
                    shape = RoundedCornerShape(roundedCornerShapeButton),
                    border = BorderStroke(broderStrokeShape, if (selectedAbility == ability) secondaryContainerLight else onPrimaryLight),
                    colors = ButtonColors(containerColor = primaryLight, contentColor = primaryLight,
                        disabledContainerColor = onPrimaryContainerLight, disabledContentColor = onPrimaryContainerLight)
                ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(ability.displayIcon)
                                .crossfade(true)
                                .build(),
                            placeholder = null,
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(50.dp),
                        )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        TitleText(text = "${selectedAbility?.displayName}", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(8.dp))
        BodyTextParagraph(text = "${selectedAbility?.description}")
        Spacer(modifier = Modifier.height(16.dp))
    }
}