package com.example.valorant_agents_module.domain.usecase

import com.example.valorant_agents_module.data.models.entities.AgentEntity
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

    suspend fun getAgents(): ValorantNetworkResult<List<AgentDomainModel>> {
        return try {
            try{
                agents = agentRepository.getAgents()
            } catch (ex: Exception) {
                return ValorantNetworkResult.ErrorStatus(message = ex.message)
            }
            domainMapper.convertListEntityToDomain(agents)
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
}

