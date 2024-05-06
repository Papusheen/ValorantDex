package com.example.valorant_agents_module.data.models.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "agents")
data class AgentEntity (
    @PrimaryKey
    val uuid: String,
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
    @Embedded
    val role: RoleEntity?,
    @Embedded
    val recruitmentData: RecruitmentEntity?,
    val abilities: List<AbilityEntity>?,
    val voiceLine: String?
)