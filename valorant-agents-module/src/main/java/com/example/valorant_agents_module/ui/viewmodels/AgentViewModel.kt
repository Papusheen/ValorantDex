package com.example.valorant_agents_module.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.valorant_agents_module.domain.models.AgentDomainModel
import com.example.valorant_agents_module.domain.usecase.AgentsUseCase
import com.example.valorant_commons.network.data.ValorantNetworkResult
import com.example.valorant_commons.viewmodel.ValorantBaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentViewModel @Inject constructor(
    private val agentsUseCase: AgentsUseCase,
    private val dispatcher: CoroutineDispatcher,
): ValorantBaseViewModel() {
    private var _agentsLiveData = MutableLiveData<ValorantNetworkResult<List<AgentDomainModel>>>()

    val agentsLiveData: LiveData<ValorantNetworkResult<List<AgentDomainModel>>>
        get() = _agentsLiveData

    private var _agentByIdLiveData = MutableLiveData<ValorantNetworkResult<AgentDomainModel>>()

    val agentByIdLiveData: LiveData<ValorantNetworkResult<AgentDomainModel>>
        get() = _agentByIdLiveData

    private var _agentsFavoritesLiveData = MutableLiveData<List<AgentDomainModel>>()

    val agentsFavoritesLiveData: LiveData<List<AgentDomainModel>>
        get() = _agentsFavoritesLiveData

    fun getAgents() {
        viewModelScope.launch(dispatcher) {
            _agentsLiveData.postValue(ValorantNetworkResult.LoadingStatus())
            val result = agentsUseCase.getAgents()
            _agentsLiveData.postValue(result)
        }
    }

    fun getAgentById(agentId: String) {
        viewModelScope.launch(dispatcher) {
            _agentByIdLiveData.postValue(ValorantNetworkResult.LoadingStatus())
            _agentByIdLiveData.postValue(agentsUseCase.getAgentById(agentId))
        }
    }

    fun getFavoritesAgents() {
        viewModelScope.launch(dispatcher) {
            _agentsFavoritesLiveData.postValue(listOf())
            val result = agentsUseCase.getFavoriteAgents()
            _agentsFavoritesLiveData.postValue(result)
        }
    }

    fun changeFavoriteAgent(agentId: String?) {
        viewModelScope.launch(dispatcher) {
            agentsUseCase.changeFavoriteAgent(agentId)
        }
    }
}