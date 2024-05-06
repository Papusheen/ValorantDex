package com.example.valorant_agents_module.di

import android.content.Context
import com.example.valorant_agents_module.data.dao.AgentDao
import com.example.valorant_agents_module.data.dao.AgentDatabase
import com.example.valorant_agents_module.data.mappers.AgentDataMapper
import com.example.valorant_agents_module.data.remote.AgentRemoteDataSource
import com.example.valorant_agents_module.data.remote.AgentService
import com.example.valorant_agents_module.data.repository.AgentRepository
import com.example.valorant_agents_module.domain.mappers.AgentDomainMapper
import com.example.valorant_commons.network.data.DataAccessStrategy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AgentsModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AgentDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideAgentsDao(db: AgentDatabase) = db.agentDao()

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(agentsService: AgentService) =
        AgentRemoteDataSource(agentsService)

    @Singleton
    @Provides
    fun provideAgentDataMapper() = AgentDataMapper()

    @Singleton
    @Provides
    fun provideAgentDomainMapper() = AgentDomainMapper()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): AgentService =
        retrofit.create(AgentService::class.java)

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: AgentRemoteDataSource,
                          localDataSource: AgentDao,
                          dataAccessStrategy: DataAccessStrategy,
                          mapper: AgentDataMapper
    ) =
        AgentRepository(localDataSource, remoteDataSource, dataAccessStrategy, mapper)
}