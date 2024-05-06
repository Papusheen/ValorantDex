package com.example.valorant_agents_module.data.models.responses

data class AgentResponse(
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
    val backgroundGradientColors: List<String?>,
    val assetPath: String?,
    val isFullPortraitRightFacing: Boolean?,
    val isPlayableCharacter: Boolean?,
    val isAvailableForTest: Boolean?,
    val isBaseContent: Boolean?,
    val role: RoleResponse?,
    val recruitmentData: RecruitmentResponse?,
    val abilities: List<AbilityResponse?>,
    val voiceLine: String?
)