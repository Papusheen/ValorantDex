package com.example.valorant_agents_module.data.remote

import com.example.valorant_agents_module.data.models.responses.AgentResponse
import com.example.valorant_commons.network.data.models.ValorantResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AgentService {
    @GET("v1/agents")
    suspend fun getAgents(): ValorantResponse<List<AgentResponse>>
    @GET("v1/agents/{agentUuid}")
    suspend fun getAgent(@Path("agentUuid") id: String): ValorantResponse<AgentResponse>
}