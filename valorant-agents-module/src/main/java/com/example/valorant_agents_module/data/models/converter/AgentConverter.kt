package com.example.valorant_agents_module.data.models.converter

import androidx.room.TypeConverter
import com.example.valorant_agents_module.data.models.entities.AbilityEntity
import com.example.valorant_agents_module.data.models.entities.AgentEntity
import com.example.valorant_agents_module.data.models.entities.RoleEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class AgentConverter {
    val gson = Gson()
    @TypeConverter
    fun fromListToString(list: List<*>): String {
        val type = object: TypeToken<List<*>>() {}.type
        return gson.toJson(list, type)
    }
    @TypeConverter
    fun toListString(dataString: String?): List<String> {
        if(dataString.isNullOrEmpty()) {
            return mutableListOf()
        }
        val type: Type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(dataString, type)
    }
    @TypeConverter
    fun fromRoleEntity(roleEntity: RoleEntity): String {
        return gson.toJson(roleEntity)
    }

    @TypeConverter
    fun toRoleEntity(roleEntityString: String): RoleEntity {
        return gson.fromJson(roleEntityString, RoleEntity::class.java)
    }

    @TypeConverter
    fun fromAbilityList(abilityList: List<AbilityEntity>): String {
        return gson.toJson(abilityList)
    }

    @TypeConverter
    fun toAbilityList(abilityListString: String): List<AbilityEntity> {
        val type = object : TypeToken<List<AbilityEntity>>() {}.type
        return gson.fromJson(abilityListString, type)
    }

    @TypeConverter
    fun fromList(list: List<AgentEntity>): String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun toList(data: String): List<AgentEntity> {
        val listType = object : TypeToken<List<AgentEntity>>() {}.type
        return gson.fromJson(data, listType)
    }
}