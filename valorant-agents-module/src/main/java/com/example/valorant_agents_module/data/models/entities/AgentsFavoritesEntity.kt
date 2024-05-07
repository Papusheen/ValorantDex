package com.example.valorant_agents_module.data.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AgentFavorites")
data class AgentFavoritesEntity(
    @PrimaryKey
    val uuid: String,
)