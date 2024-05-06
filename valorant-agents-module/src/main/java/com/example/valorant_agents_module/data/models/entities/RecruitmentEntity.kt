package com.example.valorant_agents_module.data.models.entities

import androidx.room.Entity

@Entity(tableName = "abilities")
data class RecruitmentEntity(
    val counterId: String?,
    val milestoneId: String?,
    val milestoneThreshold: Int?,
    val useLevelVpCostOverride: Boolean?,
    val levelVpCostOverride: Int?,
    val startDate: String?,
    val endDate: String?
)