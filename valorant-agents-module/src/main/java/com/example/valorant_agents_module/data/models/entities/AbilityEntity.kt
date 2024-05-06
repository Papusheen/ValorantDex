package com.example.valorant_agents_module.data.models.entities

import androidx.room.Entity

@Entity(tableName = "abilities")
data class AbilityEntity(
val slot: String?,
val displayName: String?,
val description: String?,
val displayIcon: String?
)