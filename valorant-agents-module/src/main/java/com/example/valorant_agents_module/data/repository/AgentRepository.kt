package com.example.valorant_agents_module.data.repository

import com.example.valorant_agents_module.data.dao.AgentDao
import com.example.valorant_agents_module.data.mappers.AgentDataMapper
import com.example.valorant_agents_module.data.models.entities.AgentFavoritesEntity
import com.example.valorant_agents_module.data.remote.AgentRemoteDataSource
import com.example.valorant_commons.network.data.DataAccessStrategy
import javax.inject.Inject

class AgentRepository @Inject constructor(
    private val localDataSource: AgentDao,
    private val remoteDataSource: AgentRemoteDataSource,
    private val dataAccessStrategy: DataAccessStrategy,
    private val dataMapper: AgentDataMapper,
) {
    suspend fun getAgentById(agentId: String) = dataAccessStrategy.performGetOperation(
        databaseQuery = { localDataSource.getAgent(agentId) },
        databaseQueryOnError = { localDataSource.getAgent(agentId) },
        networkCall = { remoteDataSource.getAgent(agentId) },
        saveCallResult = { localDataSource.insertAgent(dataMapper.map(it)) }
    )

    suspend fun getAgents() = dataAccessStrategy.performGetOperation(
        databaseQuery = { localDataSource.getAllAgents() },
        databaseQueryOnError = { localDataSource.getAgentsOnError() },
        networkCall = { remoteDataSource.getAgents() },
        saveCallResult = { localDataSource.insertAllAgents(dataMapper.map(it)) }
    )

    fun getFavoriteAgents() = localDataSource.getFavoritesAgent()

    fun changeFavoriteAgent(agentFavorite: AgentFavoritesEntity) =
        localDataSource.insertOrRemoveFavoriteAgent(agentFavorite)
}