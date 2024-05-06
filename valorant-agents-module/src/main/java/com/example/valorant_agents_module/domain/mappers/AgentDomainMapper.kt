package com.example.valorant_agents_module.domain.mappers

import com.example.valorant_agents_module.data.models.entities.AbilityEntity
import com.example.valorant_agents_module.data.models.entities.AgentEntity
import com.example.valorant_agents_module.data.models.entities.RecruitmentEntity
import com.example.valorant_agents_module.data.models.entities.RoleEntity
import com.example.valorant_agents_module.domain.models.AbilityDomainModel
import com.example.valorant_agents_module.domain.models.AgentDomainModel
import com.example.valorant_agents_module.domain.models.RecruitmentDomainModel
import com.example.valorant_agents_module.domain.models.RoleDomainModel
import com.example.valorant_commons.network.data.ValorantNetworkResult

class AgentDomainMapper {
    fun convertListEntityToDomain(responseResult: ValorantNetworkResult<List<AgentEntity>>): ValorantNetworkResult<List<AgentDomainModel>> {
        return when (responseResult) {
            is ValorantNetworkResult.SuccessStatus -> {
                val domainModels = responseResult.data?.map { agentResponse ->
                    map(agentResponse)
                } ?: emptyList()
                ValorantNetworkResult.SuccessStatus(domainModels)
            }
            is ValorantNetworkResult.ErrorStatus -> ValorantNetworkResult.ErrorStatus(message = responseResult.message)
            is ValorantNetworkResult.LoadingStatus -> ValorantNetworkResult.LoadingStatus()
        }
    }

    fun convertEntityToDomain(responseResult: ValorantNetworkResult<AgentEntity>): ValorantNetworkResult<AgentDomainModel> {
        return when (responseResult) {
            is ValorantNetworkResult.SuccessStatus -> {
                val domainModels = map(responseResult.data)
                ValorantNetworkResult.SuccessStatus(domainModels)
            }
            is ValorantNetworkResult.ErrorStatus -> ValorantNetworkResult.ErrorStatus(message = responseResult.message)
            is ValorantNetworkResult.LoadingStatus -> ValorantNetworkResult.LoadingStatus()
        }
    }

    private fun map(agentResponse: AgentEntity?): AgentDomainModel {
        return AgentDomainModel(
            uuid = agentResponse?.uuid,
            displayName = agentResponse?.displayName,
            description = agentResponse?.description,
            developerName = agentResponse?.developerName,
            displayIcon = agentResponse?.developerName,
            displayIconSmall = agentResponse?.displayIconSmall,
            bustPortrait = agentResponse?.bustPortrait,
            fullPortrait = agentResponse?.fullPortrait,
            fullPortraitV2 = agentResponse?.fullPortraitV2,
            killfeedPortrait = agentResponse?.killfeedPortrait,
            background = agentResponse?.background,
            assetPath = agentResponse?.assetPath,
            role = agentResponse?.role?.let { map(it) },
            recruitmentDomainModel = agentResponse?.recruitmentData?.let { map(it) },
            abilities = agentResponse?.abilities?.map { map(it) },
        )
    }

    private fun map(roleResponse: RoleEntity): RoleDomainModel {
        return RoleDomainModel(
                uuid = roleResponse.uuid,
                displayName = roleResponse.displayName,
                displayIcon = roleResponse.displayIcon,
                description = roleResponse.description,
                assetPath = roleResponse.assetPath,
            )
    }

    private fun map(abilityEntity: AbilityEntity): AbilityDomainModel {
        return AbilityDomainModel(
            slot = abilityEntity.slot,
            displayName = abilityEntity.displayName,
            displayIcon = abilityEntity.displayIcon,
            description = abilityEntity.description,
        )
    }

    private fun map(recruitmentEntity: RecruitmentEntity): RecruitmentDomainModel {
        return RecruitmentDomainModel(
            counterId = recruitmentEntity.counterId,
            milestoneId = recruitmentEntity.milestoneId,
            milestoneThreshold = recruitmentEntity.milestoneThreshold,
            useLevelVpCostOverride = recruitmentEntity.useLevelVpCostOverride,
            levelVpCostOverride = recruitmentEntity.levelVpCostOverride,
            startDate = recruitmentEntity.startDate,
            endDate = recruitmentEntity.endDate,
        )
    }
}