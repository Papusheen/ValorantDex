package com.example.valorant_agents_module.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.valorant_agents_module.data.models.entities.AgentEntity
import com.example.valorant_agents_module.data.models.entities.AgentFavoritesEntity

@Dao
interface AgentDao {
    @Query("SELECT * FROM agents")
    fun getAllAgents(): List<AgentEntity>

    @Query("SELECT * FROM agents LIMIT 4")
    fun getAgentsOnError(): List<AgentEntity>

    @Query("SELECT * FROM agents WHERE uuid = :uuid")
    fun getAgent(uuid: String): AgentEntity

    @Query("SELECT * FROM agents INNER JOIN agentfavorites ON agents.uuid = agentfavorites.uuid")
    fun getFavoritesAgent(): List<AgentEntity>

    @Query("SELECT * FROM agentfavorites WHERE uuid = :uuid")
    fun getAgentFavorite(uuid: String): AgentFavoritesEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAgent(agent: AgentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteAgent(agent: AgentFavoritesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAgents(characters: List<AgentEntity>)

    @Delete
    fun deleteFavoriteAgent(agent: AgentFavoritesEntity)

    @Transaction
    fun insertOrRemoveFavoriteAgent(agent: AgentFavoritesEntity) {
        val existingAgent = getAgentFavorite(agent.uuid)
        if (existingAgent != null) {
            deleteFavoriteAgent(existingAgent)
        } else {
            insertFavoriteAgent(agent)
        }
    }
    @Delete
    fun deleteAgent(agent: AgentEntity)
}