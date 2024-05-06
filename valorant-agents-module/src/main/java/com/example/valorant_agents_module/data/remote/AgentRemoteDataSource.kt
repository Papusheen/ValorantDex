package com.example.valorant_agents_module.data.remote

import com.example.valorant_commons.network.data.BaseDataSource
import javax.inject.Inject

class AgentRemoteDataSource  @Inject constructor(
    private val agentService: AgentService
) : BaseDataSource() {
    suspend fun getAgents() = getResult { agentService.getAgents() }
    suspend fun getAgent(id: String) = getResult { agentService.getAgent(id) }
}