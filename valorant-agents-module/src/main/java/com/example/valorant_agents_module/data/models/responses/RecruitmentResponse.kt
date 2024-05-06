package com.example.valorant_agents_module.data.models.responses

data class RecruitmentResponse(
val counterId: String?,
val milestoneId: String?,
val milestoneThreshold: Int?,
val useLevelVpCostOverride: Boolean?,
val levelVpCostOverride: Int?,
val startDate: String?,
val endDate: String?
)