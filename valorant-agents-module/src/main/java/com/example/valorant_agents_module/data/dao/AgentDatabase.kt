package com.example.valorant_agents_module.data.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.valorant_agents_module.data.models.converter.AgentConverter
import com.example.valorant_agents_module.data.models.entities.AgentEntity
import com.example.valorant_agents_module.data.models.entities.AgentFavoritesEntity

@Database(entities = [AgentEntity::class, AgentFavoritesEntity::class], version = 3)
@TypeConverters(AgentConverter::class)
abstract class AgentDatabase : RoomDatabase() {
    abstract fun agentDao(): AgentDao
    companion object {
        @Volatile private var instance: AgentDatabase? = null

        fun getDatabase(context: Context): AgentDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AgentDatabase::class.java, "agents")
                .fallbackToDestructiveMigration()
                .build()
    }
}
