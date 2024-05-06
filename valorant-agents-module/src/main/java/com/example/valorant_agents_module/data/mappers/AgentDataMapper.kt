package com.example.valorant_agents_module.data.mappers

import com.example.valorant_agents_module.data.models.entities.AbilityEntity
import com.example.valorant_agents_module.data.models.entities.AgentEntity
import com.example.valorant_agents_module.data.models.entities.RecruitmentEntity
import com.example.valorant_agents_module.data.models.entities.RoleEntity
import com.example.valorant_agents_module.data.models.responses.AbilityResponse
import com.example.valorant_agents_module.data.models.responses.AgentResponse
import com.example.valorant_agents_module.data.models.responses.RecruitmentResponse
import com.example.valorant_agents_module.data.models.responses.RoleResponse

class AgentDataMapper {

    fun map(agentsResponse: List<AgentResponse>) : List<AgentEntity> {
        return agentsResponse.map { map(it) }
    }

    fun map(agentResponse: AgentResponse) : AgentEntity {
        return AgentEntity(
            uuid = agentResponse.uuid ?: "",
            displayName = agentResponse.displayName,
            description = agentResponse.description,
            developerName = agentResponse.developerName,
            displayIcon = agentResponse.developerName,
            displayIconSmall = agentResponse.displayIconSmall,
            bustPortrait = agentResponse.bustPortrait,
            fullPortrait = agentResponse.fullPortrait,
            fullPortraitV2 = agentResponse.fullPortraitV2,
            killfeedPortrait = agentResponse.killfeedPortrait,
            background = agentResponse.background,
            backgroundGradientColors = agentResponse.backgroundGradientColors,
            assetPath = agentResponse.assetPath,
            isAvailableForTest = agentResponse.isAvailableForTest,
            isFullPortraitRightFacing = agentResponse.isFullPortraitRightFacing,
            isPlayableCharacter = agentResponse.isPlayableCharacter,
            isBaseContent = agentResponse.isBaseContent,
            role = agentResponse.role?.let { map(it) },
            recruitmentData = agentResponse.recruitmentData?.let { map(it) },
            abilities = agentResponse.abilities?.mapNotNull { it }?.map { map(it) } ?: emptyList(),
            voiceLine = agentResponse.voiceLine,
        )
    }

    private fun map(roleResponse: RoleResponse) : RoleEntity {
        return RoleEntity(
            uuid = roleResponse.uuid,
            displayName = roleResponse.displayName,
            displayIcon = roleResponse.displayIcon,
            description = roleResponse.description,
            assetPath = roleResponse.assetPath,
        )
    }

    private fun map(abilitiesResponse: AbilityResponse) : AbilityEntity {
        return AbilityEntity(
            slot = abilitiesResponse.slot,
            displayName = abilitiesResponse.displayName,
            description = abilitiesResponse.description,
            displayIcon = abilitiesResponse.displayIcon,
        )
    }

    private fun map(recruitmentResponse: RecruitmentResponse) : RecruitmentEntity {
        return RecruitmentEntity(
            counterId = recruitmentResponse.counterId,
            milestoneId = recruitmentResponse.milestoneId,
            milestoneThreshold = recruitmentResponse.milestoneThreshold,
            useLevelVpCostOverride = recruitmentResponse.useLevelVpCostOverride,
            levelVpCostOverride = recruitmentResponse.levelVpCostOverride,
            startDate = recruitmentResponse.startDate,
            endDate = recruitmentResponse.endDate,
        )
    }
}