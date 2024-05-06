package com.example.valorant_agents_module.data.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "roles")
data class RoleEntity (
    @ColumnInfo(name = "role_uuid")
    val uuid: String?,
    @ColumnInfo(name = "role_display_name")
    val displayName: String?,
    @ColumnInfo(name = "role_description")
    val description: String?,
    @ColumnInfo(name = "role_display_icon")
    val displayIcon: String?,
    @ColumnInfo(name = "role_asset_path")
    val assetPath: String?
)