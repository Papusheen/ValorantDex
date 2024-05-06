package com.example.valorant_agents_module.domain.models

import java.io.Serializable

data class AgentDomainModel(
    val uuid: String?,
    val displayName: String?,
    val description: String?,
    val developerName: String?,
    val displayIcon: String?,
    val displayIconSmall: String?,
    val bustPortrait: String?,
    val fullPortrait: String?,
    val fullPortraitV2: String?,
    val killfeedPortrait: String?,
    val background: String?,
    val assetPath: String?,
    val recruitmentDomainModel: RecruitmentDomainModel?,
    val role: RoleDomainModel?,
    val abilities: List<AbilityDomainModel>?,
): Serializable