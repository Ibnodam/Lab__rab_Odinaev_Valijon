package com.example.datastore

import android.content.Context
import androidx.datastore.dataStore

private val Context.protoDataStore by dataStore("settings.json", SettingsSerializer)

class ProtoDataStoreManager(val context: Context) {

    suspend fun saveColor(color: ULong){
        context.protoDataStore.updateData { data ->
            data.copy(backgroundColor = color)
        }
    }

    suspend fun saveTextSize(textSize: Int){
        context.protoDataStore.updateData { data ->
            data.copy(textSize = textSize)
        }
    }

    suspend fun saveAll(settings: SettingsData){
        context.protoDataStore.updateData {
            settings
        }
    }

    fun getSettings() = context.protoDataStore.data
}