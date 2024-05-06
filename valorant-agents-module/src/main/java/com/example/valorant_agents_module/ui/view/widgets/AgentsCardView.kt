package com.example.valorant_agents_module.ui.view.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.valorant_agents_module.domain.models.AgentDomainModel
import com.example.valorant_agents_module.domain.models.RecruitmentDomainModel
import com.example.valorant_agents_module.domain.models.RoleDomainModel
import com.example.valorant_commons.constants.NavigationRoutes.Companion.agentDetailsBaseScreen
import com.example.valorant_commons_ui.images.AgentCardImage
import com.example.valorant_commons_ui.messures.agentCardElevation
import com.example.valorant_commons_ui.messures.broderStrokeShape
import com.example.valorant_commons_ui.messures.cardAgentHeight
import com.example.valorant_commons_ui.messures.cardSmallPadding
import com.example.valorant_commons_ui.messures.roundedCornerShape
import com.example.valorant_commons_ui.textview.CardBodyTextParagraph
import com.example.valorant_commons_ui.textview.CardTitleText
import com.example.valorant_commons_ui.theme.AppTheme
import com.example.valorant_commons_ui.theme.ValorantViewPreviews
import com.example.valorant_commons_ui.theme.primaryContainerLight
import com.example.valorant_commons_ui.theme.primaryLight
import com.example.valorant_commons_ui.theme.secondaryContainerLight

@Composable
fun AgentCartView(
    agentDomainModel: AgentDomainModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Card(
        modifier
            .padding(cardSmallPadding)
            .height(cardAgentHeight)
            .fillMaxWidth()
            .clickable {
                navController.navigate(agentDetailsBaseScreen + agentDomainModel.uuid)},
        shape = RoundedCornerShape(roundedCornerShape),
        border = BorderStroke(broderStrokeShape, secondaryContainerLight),
        elevation = CardDefaults.cardElevation(
            defaultElevation = agentCardElevation
        )
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .background(primaryLight)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(cardSmallPadding)
                    .align(Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AgentCardImage(urlAgent = agentDomainModel.displayIconSmall, urlBackgroundAgent = agentDomainModel.background)
                Spacer(modifier = Modifier.size(cardSmallPadding))
                CardTitleText("// ${agentDomainModel.displayName}", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.size(cardSmallPadding))
                CardBodyTextParagraph("// ROLE: ${agentDomainModel.role?.displayName}", textAlign = TextAlign.Center)
            }
        }
    }
}

@ValorantViewPreviews
@Composable
private fun ComposablePreview() {
    val dummyAgent=AgentDomainModel("",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        RecruitmentDomainModel("",
            "",
            0,
            false,
            0,
            "",
            ""),
        RoleDomainModel("",
            "",
            "",
            "",
            ""),
        listOf(),
        )
    AppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(primaryContainerLight),
                    columns = GridCells.Adaptive(minSize = 200.dp)
                ) {
                    item {
                        AgentCartView(dummyAgent,navController =  rememberNavController())
                    }
                    item {
                        AgentCartView(dummyAgent,navController =  rememberNavController())
                    }
                    item {
                        AgentCartView(dummyAgent, navController =  rememberNavController())
                    }
                }
            }
        }
    }
}