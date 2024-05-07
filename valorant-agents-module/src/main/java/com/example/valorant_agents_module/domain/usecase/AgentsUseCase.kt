package com.example.valorant_agents_module.domain.usecase

import android.util.Log
import com.example.valorant_agents_module.data.models.entities.AgentEntity
import com.example.valorant_agents_module.data.models.entities.AgentFavoritesEntity
import com.example.valorant_agents_module.data.repository.AgentRepository
import com.example.valorant_agents_module.domain.mappers.AgentDomainMapper
import com.example.valorant_agents_module.domain.models.AgentDomainModel
import com.example.valorant_commons.network.data.ValorantNetworkResult
import javax.inject.Inject

class AgentsUseCase @Inject constructor(
    private val agentRepository: AgentRepository,
    private val domainMapper: AgentDomainMapper,
) {
    private lateinit var agents: ValorantNetworkResult<List<AgentEntity>>
    private lateinit var agentById: ValorantNetworkResult<AgentEntity>
    private lateinit var agentsFavorites: List<AgentEntity>

    suspend fun getAgents(): ValorantNetworkResult<List<AgentDomainModel>> {
        return try {
            try{
                agents = agentRepository.getAgents()
            } catch (ex: Exception) {
                return ValorantNetworkResult.ErrorStatus(message = ex.message)
            }
            val agentsDomainList = domainMapper.convertListEntityToDomain(agents)
            try {
                agentsFavorites = agentRepository.getFavoriteAgents()
            } catch (ex: Exception) {
                return ValorantNetworkResult.ErrorStatus(message = ex.message)
            }
            val favoritesDomainList =  domainMapper.convertListEntityToDomain(agentsFavorites)
            favoritesDomainList.forEach { favoriteAgent ->
                agentsDomainList.data?.forEach { agent ->
                    if (favoriteAgent.uuid == agent.uuid) {
                        agent.isFavorite = true
                    }
                }
            }
            agentsDomainList
        } catch (ex: Exception) {
            return ValorantNetworkResult.ErrorStatus(message = "Mapping Error")
        }
    }

    suspend fun getAgentById(agentId: String): ValorantNetworkResult<AgentDomainModel> {
        return try {
            try{
                agentById = agentRepository.getAgentById(agentId)
            } catch (ex: Exception) {
                return ValorantNetworkResult.ErrorStatus(message = ex.message)
            }
            domainMapper.convertEntityToDomain(agentById)
        } catch (ex: Exception) {
            return ValorantNetworkResult.ErrorStatus(message = "Mapping Error")
        }
    }

    fun getFavoriteAgents(): List<AgentDomainModel> {
        return try {
            agentsFavorites = agentRepository.getFavoriteAgents()
            val domainList = domainMapper.convertListEntityToDomain(agentsFavorites)
            domainList.forEach { agent ->
                agent.isFavorite = true
            }
            domainList
        } catch (ex: Exception) {
            return listOf()
        }
    }

    fun changeFavoriteAgent(agentId: String?) {
        try {
            if (!agentId.isNullOrEmpty()) {
                agentRepository.changeFavoriteAgent(AgentFavoritesEntity(agentId))
            }
        } catch (ex: Exception) {
            Log.d("database error", ex.message.toString())
        }
    }
}

