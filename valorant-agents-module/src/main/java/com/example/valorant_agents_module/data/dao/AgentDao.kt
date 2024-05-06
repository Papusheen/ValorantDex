package com.example.valorant_agents_module.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.valorant_agents_module.data.models.entities.AgentEntity

@Dao
interface AgentDao {
    @Query("SELECT * FROM agents")
    fun getAllAgents(): List<AgentEntity>

    @Query("SELECT * FROM agents LIMIT 4")
    fun getAgentsOnError(): List<AgentEntity>

    @Query("SELECT * FROM agents WHERE uuid = :uuid")
    fun getAgent(uuid: String): AgentEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAgent(agent: AgentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAgents(characters: List<AgentEntity>)

    @Delete
    fun deleteAgent(agent: AgentEntity)
}